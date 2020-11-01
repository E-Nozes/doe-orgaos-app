package com.lucasnav.doeorgaosam.modules.faq.networking

import android.annotation.SuppressLint
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.faq.model.Question
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuestionsNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(QuestionApi::class.java) }

    @SuppressLint("CheckResult")
    fun getQuestionsFromApi(
        onSuccess: (questionsResponse: List<Question>) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.getQuestion()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let{onSuccess(it)}
            }, {
                val error = RequestError(
                    -1,
                    it.message.toString()
                )
                onError(error)
            })
    }
}