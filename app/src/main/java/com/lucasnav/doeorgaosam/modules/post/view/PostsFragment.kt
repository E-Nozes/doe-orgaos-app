package com.lucasnav.doeorgaosam.modules.post.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.MainActivity
import com.lucasnav.doeorgaosam.modules.post.adapter.PostsAdapter
import com.lucasnav.doeorgaosam.modules.post.networking.PostsNetworking
import com.lucasnav.doeorgaosam.modules.post.repository.PostsRepository
import com.lucasnav.doeorgaosam.modules.post.viewmodel.PostViewModelFactory
import com.lucasnav.doeorgaosam.modules.post.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_posts.*

class PostsFragment : Fragment() {

    private lateinit var postsViewmodel: PostsViewModel
    private lateinit var postsAdapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupViewModel()

        subscribeUI()

        postsViewmodel.getPosts()
    }

    private fun setupViewModel() {
        postsViewmodel = ViewModelProvider(
            this,
            PostViewModelFactory(
                PostsRepository(PostsNetworking())
            )
        ).get(PostsViewModel::class.java)
    }

    private fun setupRecyclerView() {
        postsAdapter = PostsAdapter()

        with(rvPosts) {
            setHasFixedSize(true)
            adapter = postsAdapter
        }
    }

    private fun subscribeUI() {
        with(postsViewmodel) {

            onLoadFinished.observe(requireActivity(), Observer {
                progressBar.visibility = View.GONE
            })

            onError.observe(requireActivity(), Observer {

            })

            posts.observe(requireActivity(), Observer { newPosts ->
                postsAdapter.update(newPosts)
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PostsFragment()
    }
}