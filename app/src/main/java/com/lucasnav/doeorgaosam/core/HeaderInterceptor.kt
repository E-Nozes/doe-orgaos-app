package com.lucasnav.doeorgaosam.core

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Authorization", "Bearer $ACCESS_TOKEN")
            .build()
        return chain.proceed(request)
    }
}