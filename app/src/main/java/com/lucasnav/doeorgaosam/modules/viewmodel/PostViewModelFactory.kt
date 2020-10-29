package com.lucasnav.doeorgaosam.modules.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.modules.repository.PostsRepository

class PostViewModelFactory(
    private val postsRepository: PostsRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostsViewModel(
            postsRepository
        ) as T
    }
}