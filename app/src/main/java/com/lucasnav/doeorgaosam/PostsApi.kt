package com.lucasnav.doeorgaosam

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

const val ACCESS_TOKEN =
    "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDM4NTExNjcsInVzZXJfbmFtZSI6ImdhYnJpZWxAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9SRUdJU1RFUl9MSUtFIiwiUk9MRV9SRUdJU1RFUl9VU0VSIiwiUk9MRV9VUERBVEVfVVNFUiIsIlJPTEVfUkVNT1ZFX1VTRVIiLCJST0xFX1VQREFURV9QT1NUIiwiUk9MRV9TRUFSQ0hfUE9TVCIsIlJPTEVfUkVNT1ZFX1BPU1QiLCJST0xFX1JFTU9WRV9MSUtFIiwiUk9MRV9SRUdJU1RFUl9QT1NUIiwiUk9MRV9TRUFSQ0hfVVNFUiJdLCJqdGkiOiI3ZjM4ODBkYy0wMDMwLTQ1ZTgtOTQyZi1kNDk1NjA2MTdjMjgiLCJjbGllbnRfaWQiOiJyZWFjdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.vWc25AGMNXhDWb8LLjcus0i41rwL2dzftEDPTSOCYO0"

interface PostsApi {

    @GET("posts?size=10")
    fun getPosts(
        @Header("access-token") accessToken: String? = ACCESS_TOKEN
    ): Observable<RequestResponse<Post>>
}