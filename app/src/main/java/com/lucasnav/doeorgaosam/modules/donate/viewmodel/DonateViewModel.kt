package com.lucasnav.doeorgaosam.modules.donate.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasnav.doeorgaosam.core.SingleLiveEvent
import com.lucasnav.doeorgaosam.modules.donate.model.Donate
import com.lucasnav.doeorgaosam.modules.donate.repository.DonateRepository
import com.lucasnav.doeorgaosam.core.RequestError

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