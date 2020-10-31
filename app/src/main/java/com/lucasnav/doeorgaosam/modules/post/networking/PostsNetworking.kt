package com.lucasnav.doeorgaosam.modules.post.networking

import android.annotation.SuppressLint
import com.lucasnav.doeorgaosam.modules.post.model.RequestError
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.modules.post.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PostsNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(PostsApi::class.java) }

    @SuppressLint("CheckResult")
    fun getPostsFromApi(
        onSuccess: (postsResponse: List<Post>) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.content?.let{onSuccess(it)}
            }, {
                val error = RequestError(
                    -1,
                    it.message.toString()
                )
                onError(error)
            })
    }
}