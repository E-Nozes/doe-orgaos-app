package com.lucasnav.doeorgaosam.modules.donate.networking

import com.lucasnav.doeorgaosam.modules.donate.model.Donate
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface DonateApi {

    @POST("donations")
    fun postDonate(
        @Body donateRequest: Donate
    ): Observable<Donate>
}