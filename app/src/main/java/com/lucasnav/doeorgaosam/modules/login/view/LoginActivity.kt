package com.lucasnav.doeorgaosam.modules.login.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.MainActivity
import com.lucasnav.doeorgaosam.modules.login.networking.LoginNetworking
import com.lucasnav.doeorgaosam.modules.login.repository.LoginRepository
import com.lucasnav.doeorgaosam.modules.login.viewmodel.LoginViewModel
import com.lucasnav.doeorgaosam.modules.login.viewmodel.LoginViewModelFactory
import com.lucasnav.doeorgaosam.modules.login.model.Login
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_dialog.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        finish()

        setupViewModel()

        subscribeUI()

        btLogin.setOnClickListener {
            showLoginDialog()
        }
    }

    private fun showLoginDialog() {

        with(Dialog(this)) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.login_dialog)
            dialogBtEntrar.setOnClickListener {
                loginViewModel.doLogin(
                    Login(
                        username = etUsuario.text.toString(),
                        password = etSenha.text.toString()
                    )
                )
                dismiss()
            }
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
            window!!.attributes = layoutParams
            show()
        }
    }


    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(
                LoginRepository(
                    LoginNetworking()
                )
            )
        ).get(LoginViewModel::class.java)
    }


    private fun subscribeUI() {
        with(loginViewModel) {

            onLoadFinished.observe(this@LoginActivity, Observer {
//                progressBar.visibility = View.GONE
            })

            onError.observe(this@LoginActivity, Observer {
                Toast.makeText(baseContext, "Erro, tente novamente", Toast.LENGTH_SHORT).show()
            })

            hasLogged.observe(this@LoginActivity, Observer {
                if (it) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }
            })
        }
    }

}