package com.lucasnav.doeorgaosam.modules.post.networking

import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import com.lucasnav.doeorgaosam.modules.post.model.RequestResponse
import com.lucasnav.doeorgaosam.modules.post.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostsApi {

    @GET("posts?access_token=$ACCESS_TOKEN&size=10")
    fun getPosts(
    ): Observable<RequestResponse<Post>>
}