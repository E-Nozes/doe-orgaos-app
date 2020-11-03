package com.lucasnav.doeorgaosam.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.lucasnav.doeorgaosam.modules.login.view.LoginActivity

class Helper {

    fun redirectToLogin(
        context: Context,
        activity: Activity
    ) {
        val intent = Intent(context, LoginActivity::class.java)
        context.startActivity(intent)
        Toast.makeText(context, "Token expirado, faça login novamente", Toast.LENGTH_SHORT).show()
        activity.finish()
    }

    fun catchErrorCode(
        error: RequestError,
        context: Context,
        activity: Activity
    ) {
        when(error.code) {
            400 -> {
                Helper().redirectToLogin(context,activity)
            }
            else -> {
                Toast.makeText(context, "Ocorreu um erro inesperado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}