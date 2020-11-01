package com.lucasnav.doeorgaosam.modules.faq.repository

import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.faq.model.Question
import com.lucasnav.doeorgaosam.modules.faq.networking.QuestionsNetworking

class QuestionsRepository(
    private val questionsNetworking: QuestionsNetworking
) {
    fun getQuestions(
        onSuccess: (questions: List<Question>) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        questionsNetworking.getQuestionsFromApi(
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }
}