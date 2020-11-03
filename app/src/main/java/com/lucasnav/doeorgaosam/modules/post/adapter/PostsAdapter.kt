package com.lucasnav.doeorgaosam.modules.post.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.post.model.Post
import com.lucasnav.doeorgaosam.modules.post.view.PostViewHolder

class PostsAdapter(
    var onClickListener: () -> Unit
) : RecyclerView.Adapter<PostViewHolder>() {

    private var posts: List<Post> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(onClickListener, posts[position])
    }

    fun update(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    fun clear() {
        this.posts = emptyList()
        notifyDataSetChanged()
    }
}