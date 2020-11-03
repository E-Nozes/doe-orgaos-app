package com.lucasnav.doeorgaosam.modules.post.networking

import android.annotation.SuppressLint
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.core.RequestError
import com.lucasnav.doeorgaosam.modules.post.model.NewPost
import com.lucasnav.doeorgaosam.modules.post.model.Post
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class PostsNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(PostsApi::class.java) }

    @SuppressLint("CheckResult")
    fun getPostsFromApi(
        onSuccess: (postsResponse: List<Post>) -> Unit,
        onError: (error: RequestError) -> Unit,
        page: String,
        size: String
    ) {
        api.getPosts(
            size,
            page
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.content?.let { onSuccess(it) }
            }, {
                val exception = it as HttpException
                val error = RequestError(
                    exception.code(),
                    it.message.toString()
                )
                onError(error)
            })
    }

    @SuppressLint("CheckResult")
    fun makeNewPost(
        newPost: NewPost,
        onSuccess: (hasSuccess: Boolean) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.makeNewPost(
            newPost
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onSuccess(true)
            }, {
                val error = RequestError(
                    -1,
                    it.message.toString()
                )
                onError(error)
            })
    }
}