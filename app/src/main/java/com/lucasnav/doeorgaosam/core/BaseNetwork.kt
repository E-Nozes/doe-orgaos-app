package com.lucasnav.doeorgaosam.core

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var ACCESS_TOKEN =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDQyNjUwMzYsInVzZXJfbmFtZSI6ImdhYnJpZWxAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9SRUdJU1RFUl9MSUtFIiwiUk9MRV9SRUdJU1RFUl9VU0VSIiwiUk9MRV9VUERBVEVfVVNFUiIsIlJPTEVfUkVNT1ZFX1VTRVIiLCJST0xFX1VQREFURV9QT1NUIiwiUk9MRV9SRUdJU1RFUl9ET05BVElPTiIsIlJPTEVfU0VBUkNIX1BPU1QiLCJST0xFX1JFTU9WRV9QT1NUIiwiUk9MRV9TRUFSQ0hfRkFRIiwiUk9MRV9SRU1PVkVfTElLRSIsIlJPTEVfUkVHSVNURVJfUE9TVCIsIlJPTEVfU0VBUkNIX1VTRVIiXSwianRpIjoiNWFmYzIwZjktNjk5NS00ZTUxLTk2MmMtOTkzNGI0ZDQ5OTRlIiwiY2xpZW50X2lkIjoicmVhY3QiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.JzIc0AOgEg_k5onWsBpNk4-7U-AZxeIrifhaM9yzn2g"

abstract class BaseNetwork {

    companion object {
        const val BASE_URL =
            "https://health-mater-api.herokuapp.com/"
    }

    protected fun getRetrofitBuilder(): Retrofit.Builder {

        val retrofitBuilder = Retrofit.Builder()

        with(retrofitBuilder) {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            client(BaseOkHttpClient.defaultOkHttpClient)
        }

        return retrofitBuilder
    }
}