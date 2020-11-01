package com.lucasnav.doeorgaosam.modules.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.modules.login.repository.LoginRepository

class LoginViewModelFactory(
    private val loginRepository: LoginRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(
            loginRepository
        ) as T
    }
}