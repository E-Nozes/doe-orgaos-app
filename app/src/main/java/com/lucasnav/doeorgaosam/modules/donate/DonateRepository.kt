package com.lucasnav.doeorgaosam.modules.donate

import com.lucasnav.doeorgaosam.modules.post.model.RequestError

class DonateRepository(
    private val donateNetworking: DonateNetworking
) {
    fun postDonate(
        donateRequest: Donate,
        onSuccess: (donate: Donate) -> Unit,
        onError: (error: RequestError) -> Unit
    ) {
        donateNetworking.postDonateFromApi(
            donateRequest = donateRequest,
            onSuccess = {
                onSuccess(it)
            },
            onError = {
                onError(it)
            }
        )
    }
}