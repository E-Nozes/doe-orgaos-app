package com.lucasnav.doeorgaosam

import android.annotation.SuppressLint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostsNetworking : BaseNetwork() {

    private val API by lazy { getRetrofitBuilder().build().create(PostsApi::class.java) }

    @SuppressLint("CheckResult")
    fun getPostsFromApi(
        onSuccess: (postsResponse: List<Post>) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        API.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {
                val error = RequestError(-1, it.message.toString())
                onError(error)
            })
    }
}