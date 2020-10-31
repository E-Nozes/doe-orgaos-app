package com.lucasnav.doeorgaosam.modules.post.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lucasnav.doeorgaosam.modules.post.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        post: Post
    ) {
        with(view) {
            tvName1.text = "${post.author.firstName}${post.author.lastName}"
            tvName2.text = "${post.author.firstName}${post.author.lastName}"
            tvDescription.text = post.content
        }
    }
}