package com.example.vascomm.helper

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import com.example.vascomm.databinding.SnackbarErrorBinding
import com.example.vascomm.databinding.SnackbarToastSuccessBinding
import com.google.android.material.snackbar.Snackbar

fun Activity.snackBarError(message: String, view: View? = null) {
    val snackbar: Snackbar
    if (view != null){
        //Android SnackBar above keyboard cuman bisa jalan di coordinator layout
        snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
    }else{
        snackbar = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_LONG)
    }
    val binding =
        SnackbarErrorBinding.inflate(LayoutInflater.from(this.applicationContext))
    binding.txtMessage.text = message
    snackbar.view.setBackgroundColor(Color.TRANSPARENT)

    val snackBarView = snackbar.view as Snackbar.SnackbarLayout
    snackBarView.setPadding(0, 0, 0, 0)

    snackBarView.addView(binding.root, 0)
    snackbar.show()
}

fun Activity.snackBarSuccess(message: String, view: View? = null) {
    val snackbar: Snackbar
    if (view != null){
        //Android SnackBar above keyboard cuman bisa jalan di coordinator layout
        snackbar = Snackbar.make(view, "", Snackbar.LENGTH_LONG)
    }else{
        snackbar = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_LONG)
    }
    val binding =
        SnackbarToastSuccessBinding.inflate(LayoutInflater.from(this.applicationContext))
    binding.txtMessage.text = message
    snackbar.view.setBackgroundColor(Color.TRANSPARENT)

    val snackBarView = snackbar.view as Snackbar.SnackbarLayout
    snackBarView.setPadding(0, 0, 0, 0)

    snackBarView.addView(binding.root, 0)
    snackbar.show()
}