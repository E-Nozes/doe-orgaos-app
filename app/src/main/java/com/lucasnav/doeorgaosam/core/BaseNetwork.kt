package com.lucasnav.doeorgaosam.core

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val ACCESS_TOKEN =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDQxOTgxODEsInVzZXJfbmFtZSI6ImdhYnJpZWxAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9SRUdJU1RFUl9MSUtFIiwiUk9MRV9SRUdJU1RFUl9VU0VSIiwiUk9MRV9VUERBVEVfVVNFUiIsIlJPTEVfUkVNT1ZFX1VTRVIiLCJST0xFX1VQREFURV9QT1NUIiwiUk9MRV9SRUdJU1RFUl9ET05BVElPTiIsIlJPTEVfU0VBUkNIX1BPU1QiLCJST0xFX1JFTU9WRV9QT1NUIiwiUk9MRV9TRUFSQ0hfRkFRIiwiUk9MRV9SRU1PVkVfTElLRSIsIlJPTEVfUkVHSVNURVJfUE9TVCIsIlJPTEVfU0VBUkNIX1VTRVIiXSwianRpIjoiNWFlMmFmZGQtYTgyOC00NDkwLTliYmQtOTRhNTBjYTBmOGQyIiwiY2xpZW50X2lkIjoicmVhY3QiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXX0.Qn4UxkS52joqnKYTyy5_78mgkIhTgm6EF2CcesTt4yI"

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