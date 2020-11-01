package com.lucasnav.doeorgaosam.modules.donate

data class Donate(
    var description: String,
    var amount: Double,
    var currency: String = "BRL"
)