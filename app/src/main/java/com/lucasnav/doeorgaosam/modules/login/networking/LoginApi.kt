package com.lucasnav.doeorgaosam.modules.login.networking

import com.lucasnav.doeorgaosam.modules.login.model.Login
import com.lucasnav.doeorgaosam.modules.login.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {

    @POST("oauth/token")
    fun login(
        @Body login: Login
    ): Observable<LoginResponse>
}