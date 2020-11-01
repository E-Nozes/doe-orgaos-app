package com.lucasnav.doeorgaosam.modules.donate

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.modules.post.model.RequestError

class DonateViewModel(
    private val donateRepository: DonateRepository
) : ViewModel() {

    var donate: MutableLiveData<Donate> = MutableLiveData()
    var onLoadFinished = SingleLiveEvent<Void>()
    var onError = SingleLiveEvent<RequestError>()

    fun postDonate(
        donateRequest: Donate
    ) {
        donateRepository.postDonate(
            donateRequest = donateRequest,
            onSuccess = {
                donate.value = it
                onLoadFinished.call()
            },
            onError = {
                onError.value = it
                onLoadFinished.call()
            })
    }
}