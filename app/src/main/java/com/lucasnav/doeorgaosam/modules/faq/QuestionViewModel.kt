package com.lucasnav.doeorgaosam.modules.faq

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.modules.post.model.RequestError

class QuestionViewModel(
    private val questionsRepository: QuestionsRepository
) : ViewModel() {

    var questions: MutableLiveData<List<Question>> = MutableLiveData()
    var onLoadFinished = SingleLiveEvent<Void>()
    var onError = SingleLiveEvent<RequestError>()

    fun getQuestions() {
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