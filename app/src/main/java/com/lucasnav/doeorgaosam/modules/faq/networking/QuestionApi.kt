package com.lucasnav.doeorgaosam.modules.faq.networking

import com.lucasnav.doeorgaosam.modules.faq.model.Question
import io.reactivex.Observable
import retrofit2.http.GET

interface QuestionApi {

    @GET("faq")
    fun getQuestion(
    ): Observable<List<Question>>
}