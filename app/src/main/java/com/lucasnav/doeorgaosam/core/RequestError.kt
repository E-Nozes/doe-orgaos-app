package com.lucasnav.doeorgaosam.core

data class RequestError(
    val code: Int = -1,
    val info: String
)