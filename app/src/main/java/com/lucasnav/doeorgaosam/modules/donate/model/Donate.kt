package com.lucasnav.doeorgaosam.modules.donate.model

data class Donate(
    var description: String,
    var amount: Double,
    var currency: String = "BRL"
)