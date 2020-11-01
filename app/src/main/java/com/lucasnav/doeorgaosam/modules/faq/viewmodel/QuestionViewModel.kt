package com.lucasnav.doeorgaosam.modules.faq.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.faq.model.Question
import com.lucasnav.doeorgaosam.modules.faq.repository.QuestionsRepository

class QuestionViewModel(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    var questions: MutableLiveData<List<Question>> = MutableLiveData()
    var onLoadFinished = SingleLiveEvent<Void>()
    var onLoadStarted = SingleLiveEvent<Void>()
    var onError = SingleLiveEvent<RequestError>()

    fun getQuestions() {

        onLoadStarted.call()

        questionsRepository.getQuestions(
            onSuccess = {
                questions.value = it
                onLoadFinished.call()
            },
            onError = {
                onError.value = it
                onLoadFinished.call()
            })
    }
}