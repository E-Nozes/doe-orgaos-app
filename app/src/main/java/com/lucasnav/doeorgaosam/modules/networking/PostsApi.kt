package com.lucasnav.doeorgaosam.modules.networking

import com.lucasnav.doeorgaosam.modules.model.RequestResponse
import com.lucasnav.doeorgaosam.modules.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

const val ACCESS_TOKEN =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDM5NDE2OTksInVzZXJfbmFtZSI6ImdhYnJpZWxAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9SRUdJU1RFUl9MSUtFIiwiUk9MRV9SRUdJU1RFUl9VU0VSIiwiUk9MRV9VUERBVEVfVVNFUiIsIlJPTEVfUkVNT1ZFX1VTRVIiLCJST0xFX1VQREFURV9QT1NUIiwiUk9MRV9TRUFSQ0hfUE9TVCIsIlJPTEVfUkVNT1ZFX1BPU1QiLCJST0xFX1NFQVJDSF9GQVEiLCJST0xFX1JFTU9WRV9MSUtFIiwiUk9MRV9SRUdJU1RFUl9QT1NUIiwiUk9MRV9TRUFSQ0hfVVNFUiJdLCJqdGkiOiJjNmRkZjJjNC00MjAzLTQwOGUtOGU0NS01MDYxNzgxY2Y4ZWQiLCJjbGllbnRfaWQiOiJyZWFjdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.ZIM9xzbYS6lyHhW0gobCRsZADDPaKQkgfe7NldEeO0U"

interface PostsApi {

    @GET("posts?size=10")
    fun getPosts(
        @Header("access-token") accessToken: String? = ACCESS_TOKEN
    ): Observable<RequestResponse<Post>>
}