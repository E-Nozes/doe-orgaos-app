package com.lucasnav.doeorgaosam.modules.donate.repository

import com.lucasnav.doeorgaosam.modules.donate.model.Donate
import com.lucasnav.doeorgaosam.modules.donate.networking.DonateNetworking
import com.lucasnav.doeorgaosam.core.RequestError

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