package com.lucasnav.doeorgaosam.modules.login.repository

import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.login.networking.LoginNetworking
import com.lucasnav.doeorgaosam.modules.login.model.Login

class LoginRepository(
    private val loginNetworking: LoginNetworking
) {
    fun doLogin(
        loginRequest: Login,
        onSuccess: (hasLogged: Boolean) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        loginNetworking.doLoginFromApi(
            loginRequest = loginRequest,
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }
}