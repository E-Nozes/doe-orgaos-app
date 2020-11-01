package com.lucasnav.doeorgaosam.modules.post.networking

import com.lucasnav.doeorgaosam.modules.post.model.Post
import com.lucasnav.doeorgaosam.modules.post.model.RequestResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface PostsApi {

    @GET("posts?size=10")
    fun getPosts(
    ): Observable<RequestResponse<Post>>
}