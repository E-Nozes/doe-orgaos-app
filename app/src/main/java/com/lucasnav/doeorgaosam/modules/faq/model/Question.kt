package com.lucasnav.doeorgaosam.modules.faq.model

data class Question(
    var id: Int,
    var question: String,
    var answer: String,
    var faqDate: String
)