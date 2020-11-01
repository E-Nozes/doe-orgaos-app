package com.lucasnav.doeorgaosam.modules.donate

import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface DonateApi {

    @POST("donations?access_token=$ACCESS_TOKEN")
    fun postDonate(
        @Body donateRequest: Donate
    ): Observable<Donate>
}