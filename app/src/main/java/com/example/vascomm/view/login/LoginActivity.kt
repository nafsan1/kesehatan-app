package com.example.vascomm.view.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.core.data.RequestLogin
import com.example.core.network.Resource
import com.example.core.util.RegisterFieldsState
import com.example.core.util.RegisterValidation
import com.example.core.util.validateEmail
import com.example.core.util.validatePassword
import com.example.vascomm.R
import com.example.vascomm.databinding.ActivityLoginBinding
import com.example.vascomm.helper.EdittextHelper.showHidePassword
import com.example.vascomm.helper.snackBarError
import com.example.vascomm.view.main.MainActivity
import com.example.vascomm.view.register.RegisterActivity
import com.example.vascomm.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtDftrSkrng.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding.loginBtn.setOnClickListener {
            getLogin()
        }
       binding.edtPass.showHidePassword()
    }

    private fun getLogin() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPass.text.toString().trim()

        if (checkValidation(email, password)) {
            getData(RequestLogin(email = email, password = password))
        } else {
            val registerFieldsState = RegisterFieldsState(
                validateEmail(email), validatePassword(password)
            )
            if (registerFieldsState.email is RegisterValidation.Failed) {
                binding.edtEmail.requestFocus()
                binding.edtEmail.error =
                    (registerFieldsState.email as RegisterValidation.Failed).message
            }
            if (registerFieldsState.password is RegisterValidation.Failed) {
                binding.edtPass.requestFocus()
                binding.edtPass.error =
                    (registerFieldsState.password as RegisterValidation.Failed).message
            }
        }

    }

    private fun checkValidation(email: String, password: String): Boolean {
        val emailValidation = validateEmail(email)
        val passwordValidation = validatePassword(password)

        return emailValidation is RegisterValidation.Success &&
                passwordValidation is RegisterValidation.Success
    }

    private fun getData(login: RequestLogin) {
        viewModel.getLogin(login)
            .observe(this@LoginActivity, Observer {
                if (it != null) {
                    when (it) {
                        is Resource.Loading -> {
                            it.isLoading?.let { loading ->

                            }
                        }
                        is Resource.Success -> {
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        is Resource.Error -> {
                            snackBarError(it.message.toString())
                        }
                        is Resource.ErrorFromServer -> {
                            snackBarError("Password not match")
                        }
                    }
                }
            })
    }
}