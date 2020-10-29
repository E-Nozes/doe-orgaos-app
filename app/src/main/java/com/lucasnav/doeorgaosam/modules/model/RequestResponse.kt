package com.lucasnav.doeorgaosam.modules.model

data class RequestResponse<T> (
    val content: List<T>?
)
