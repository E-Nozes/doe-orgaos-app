package com.lucasnav.doeorgaosam.modules.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lucasnav.doeorgaosam.modules.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        post: Post
    ){
        with(view) {
            tvTitle.text = post.author.firstName
            tvSubtitle.text = post.content
        }
    }
}