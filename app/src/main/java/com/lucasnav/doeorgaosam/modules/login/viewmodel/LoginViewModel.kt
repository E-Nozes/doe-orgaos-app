package com.lucasnav.doeorgaosam.modules.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.modules.login.repository.LoginRepository
import com.lucasnav.doeorgaosam.modules.login.model.Login

class LoginViewModel(
    private val loginRepository: LoginRepository
) : ViewModel() {

    var hasLogged: MutableLiveData<Boolean> = MutableLiveData()
    var onLoadFinished = SingleLiveEvent<Void>()
    var onError = SingleLiveEvent<RequestError>()

    fun doLogin(
        loginRequest: Login
    ) {
        loginRepository.doLogin(
            loginRequest = loginRequest,
            onSuccess = {
                hasLogged.value = it
                onLoadFinished.call()
            },
            onError = {
                onError.value = it
                onLoadFinished.call()
            }
        )
    }
}