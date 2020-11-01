package com.lucasnav.doeorgaosam.modules.login.model

data class Login(
    var grant_type: String = "password",
    var username: String,
    var password: String
)