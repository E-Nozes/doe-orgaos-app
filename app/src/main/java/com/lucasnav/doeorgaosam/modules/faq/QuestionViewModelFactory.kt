package com.lucasnav.doeorgaosam.modules.faq

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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