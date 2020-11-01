package com.lucasnav.doeorgaosam.modules.donate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.modules.donate.repository.DonateRepository

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