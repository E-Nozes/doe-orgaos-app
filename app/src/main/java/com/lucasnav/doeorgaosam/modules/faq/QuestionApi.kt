package com.lucasnav.doeorgaosam.modules.faq

import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import io.reactivex.Observable
import retrofit2.http.GET

interface QuestionApi {

    @GET("faq?access_token=$ACCESS_TOKEN")
    fun getQuestion(
    ): Observable<List<Question>>
}