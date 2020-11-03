package com.lucasnav.doeorgaosam.modules.post.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.modules.post.model.NewPost
import com.lucasnav.doeorgaosam.modules.post.model.Post
import com.lucasnav.doeorgaosam.modules.post.repository.PostsRepository

class PostsViewModel(
    private val postsRepository: PostsRepository
) : ViewModel() {

    var page = -1

    var posts: MutableLiveData<List<Post>> = MutableLiveData()

    var newPostEvent = SingleLiveEvent<Void>()

    var onLoadFinished = SingleLiveEvent<Void>()
    var onError = SingleLiveEvent<RequestError>()

    fun getPosts() {

        page++

        postsRepository.getPosts(
            size = 30.toString(),
            page = page.toString(),
            onSuccess = {
                posts.value = it
                onLoadFinished.call()
            },
            onError = {
                onError.value = it
                onLoadFinished.call()
            })
    }

    fun makeNewPost(
        newPost: NewPost
    ) {
        postsRepository.makeNewPost(
            newPost = newPost,
            onSuccess = {
                if(it) newPostEvent.call()
                onLoadFinished.call()
            },
            onError = {
                onError.value = it
                onLoadFinished.call()
            })
    }
}