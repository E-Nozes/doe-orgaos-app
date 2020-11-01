package com.lucasnav.doeorgaosam.modules.faq

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasnav.doeorgaosam.R

class QuestionsAdapter() : RecyclerView.Adapter<FaqViewHolder>() {

    private var questions: List<Question> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.faq_item, parent, false)
        return FaqViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        holder.bind(questions[position])
    }

    fun update(questions: List<Question>) {
        this.questions = questions
        notifyDataSetChanged()
    }
}