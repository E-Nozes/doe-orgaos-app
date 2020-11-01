package com.lucasnav.doeorgaosam.modules.post.model

data class Post(
    var id: Int,
    var content: String,
    var author: Author,
    var pictureUrl: String?,
    var dateTime: String
) {
    data class Author(
        var id: Int,
        var firstName: String,
        var lastName: String,
        var email: String
    )
}