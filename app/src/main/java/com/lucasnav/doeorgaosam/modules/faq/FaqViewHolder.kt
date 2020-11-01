package com.lucasnav.doeorgaosam.modules.faq

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.faq_item.view.*

class FaqViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        question: Question
    ) {
        with(view) {
            tvQuestion.text = question.question
            tvAnswer.text = question.answer
        }
    }
}