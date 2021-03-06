package com.lucasnav.doeorgaosam.modules.post.repository

import com.lucasnav.doeorgaosam.modules.post.networking.PostsNetworking
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.post.model.NewPost
import com.lucasnav.doeorgaosam.modules.post.model.Post

class PostsRepository(
    private val postsNetworking: PostsNetworking
) {
    fun getPosts(
        onSuccess: (posts: List<Post>) -> Unit,
        onError: (error: RequestError) -> Unit,
        page: String,
        size: String
    ) {
        postsNetworking.getPostsFromApi(
            size = size,
            page = page,
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }

    fun makeNewPost(
        newPost: NewPost,
        onSuccess: (hasSuccess: Boolean) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        postsNetworking.makeNewPost(
            newPost = newPost,
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }
}