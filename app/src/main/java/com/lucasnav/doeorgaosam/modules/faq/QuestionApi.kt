package com.lucasnav.doeorgaosam.modules.faq

import io.reactivex.Observable
import retrofit2.http.GET

interface QuestionApi {

    @GET("faq")
    fun getQuestion(
    ): Observable<List<Question>>
}