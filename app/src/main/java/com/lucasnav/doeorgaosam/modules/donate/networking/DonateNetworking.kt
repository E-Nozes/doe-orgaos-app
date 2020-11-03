package com.lucasnav.doeorgaosam.modules.donate.networking

import android.annotation.SuppressLint
import com.lucasnav.doeorgaosam.core.BaseNetwork
import com.lucasnav.doeorgaosam.modules.donate.model.Donate
import com.lucasnav.doeorgaosam.core.RequestError
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException

class DonateNetworking : BaseNetwork() {

    private val api by lazy { getRetrofitBuilder().build().create(DonateApi::class.java) }

    @SuppressLint("CheckResult")
    fun postDonateFromApi(
        donateRequest: Donate,
        onSuccess: (questionsResponse: Donate) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        api.postDonate(
            donateRequest
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it?.let { onSuccess(it) }
            }, {
                val exception = it as HttpException
                val error = RequestError(
                    exception.code(),
                    it.message.toString()
                )
                onError(error)
            })
    }
}