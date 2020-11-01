package com.lucasnav.doeorgaosam.modules.faq.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.modules.faq.repository.QuestionsRepository

class QuestionViewModelFactory(
    private val questionsRepository: QuestionsRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuestionViewModel(
            questionsRepository
        ) as T
    }
}