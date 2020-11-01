package com.lucasnav.doeorgaosam.modules.login.networking

import android.annotation.SuppressLint
import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.login.model.Login
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(LoginApi::class.java) }

    @SuppressLint("CheckResult")
    fun doLoginFromApi(
        loginRequest: Login,
        onSuccess: (hasLogged: Boolean) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.login(
            loginRequest
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    ACCESS_TOKEN = it.accessToken
                    onSuccess(true)
                }
            }, {
                val error = RequestError(
                    -1,
                    it.message.toString()
                )
                onError(error)
            })
    }
}