package com.lucasnav.doeorgaosam.modules.login.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("access_token")
    var accessToken: String
)
