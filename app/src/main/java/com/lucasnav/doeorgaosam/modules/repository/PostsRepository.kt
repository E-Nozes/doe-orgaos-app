package com.lucasnav.doeorgaosam.modules.repository

import com.lucasnav.doeorgaosam.modules.networking.PostsNetworking
import com.lucasnav.doeorgaosam.modules.model.RequestError
import com.lucasnav.doeorgaosam.modules.model.Post

class PostsRepository(
    private val postsNetworking: PostsNetworking
) {
    fun getPosts(
        onSuccess: (posts: List<Post>) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        postsNetworking.getPostsFromApi(
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }
}