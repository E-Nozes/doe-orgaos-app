package com.lucasnav.doeorgaosam.modules.login.networking

import com.lucasnav.doeorgaosam.modules.login.model.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface LoginApi {

    @FormUrlEncoded
    @Headers(
        "Content-Type: application/x-www-form-urlencoded",
        "Authorization: Basic cmVhY3Q6I3IzNGN0MA=="
    )
    @POST("oauth/token")
    fun login(
        @FieldMap fields: Map<String, String>
    ): Observable<LoginResponse>
}