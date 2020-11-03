package com.lucasnav.doeorgaosam.modules.login.networking

import android.annotation.SuppressLint
import android.util.Log
import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.login.model.Login
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class LoginNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(LoginApi::class.java) }

    @SuppressLint("CheckResult")
    fun doLoginFromApi(
        loginRequest: Login,
        onSuccess: (hasLogged: Boolean) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.login(
            fields = getFormFields(loginRequest.username, loginRequest.password)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let {
                    ACCESS_TOKEN = it.accessToken
                    onSuccess(true)
                }
            }, {
                val exception = it as HttpException
                val error = RequestError(
                    exception.code(),
                    it.message.toString()
                )
                Log.d("LOGIN-ERROR", it.message)
                onError(error)
            })
    }

    private fun getFormFields(email: String, password: String): Map<String, String> {
        return HashMap<String, String>().apply {
            put("username", email)
            put("password", password)
            put("grant_type", "password")
        }
    }
}