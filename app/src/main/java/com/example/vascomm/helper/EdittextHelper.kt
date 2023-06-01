package com.example.vascomm.helper

import android.annotation.SuppressLint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.EditText
import com.example.vascomm.R

object EdittextHelper {

    @SuppressLint("ClickableViewAccessibility")
     fun EditText.showHidePassword()  {
        this.setOnTouchListener { v, event ->
            val drawableRight = 2

            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (this.right - this.compoundDrawables[drawableRight].bounds.width())) {
                    if (this.transformationMethod is PasswordTransformationMethod) {
                        // Show password
                        this.transformationMethod = HideReturnsTransformationMethod.getInstance()
                        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0)
                    } else {
                        // Hide password
                        this.transformationMethod = PasswordTransformationMethod.getInstance()
                        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0)
                    }
                    return@setOnTouchListener true
                }
            }
            false
        }
    }
}