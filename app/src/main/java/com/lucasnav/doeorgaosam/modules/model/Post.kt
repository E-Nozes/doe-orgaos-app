package com.lucasnav.doeorgaosam.modules.model

data class Post(
    var id: Int,
    var content: String,
    var author: Author,
    var dateTime: String
) {
    data class Author(
        var id: Int,
        var firstName: String,
        var lastName: String,
        var email: String
    )
}