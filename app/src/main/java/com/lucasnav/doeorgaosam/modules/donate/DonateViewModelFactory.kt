package com.lucasnav.doeorgaosam.modules.donate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DonateViewModelFactory(
    private val donateRepository: DonateRepository
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DonateViewModel(
            donateRepository
        ) as T
    }
}