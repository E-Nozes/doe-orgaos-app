package com.lucasnav.doeorgaosam.modules.post.networking

import com.lucasnav.doeorgaosam.modules.post.model.Post
import com.lucasnav.doeorgaosam.modules.post.model.RequestResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsApi {

    @GET("posts")
    fun getPosts(
        @Query("size") size: String,
        @Query("page") page: String
    ): Observable<RequestResponse<Post>>
}