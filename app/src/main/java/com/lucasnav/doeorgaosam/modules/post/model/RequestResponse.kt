package com.lucasnav.doeorgaosam.modules.post.model

data class RequestResponse<T> (
    val content: List<T>?
)
