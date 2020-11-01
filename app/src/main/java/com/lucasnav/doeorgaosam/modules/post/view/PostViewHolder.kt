package com.lucasnav.doeorgaosam.modules.post.view

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.post.model.Post
import kotlinx.android.synthetic.main.post_item.view.*

class PostViewHolder(
    private val view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        onClickListener: () -> Unit,
        post: Post
    ) {
        with(view) {
            tvName1.text = "${post.author.firstName}${post.author.lastName}"
            tvName2.text = "${post.author.firstName}${post.author.lastName}"
            tvDescription.text = post.content

            Glide.with(view)
                .load(post.pictureUrl)
                .placeholder(R.drawable.ic_organsdonation)
                .override(ConstraintLayout.LayoutParams.MATCH_CONSTRAINT, ConstraintLayout.LayoutParams.MATCH_CONSTRAINT)
                .into(ivPost)

            buttonSalvarVIdas.setOnClickListener {
                onClickListener()
            }
        }
    }
}