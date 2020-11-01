package com.lucasnav.doeorgaosam.modules.post.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.MainActivity
import com.lucasnav.doeorgaosam.modules.donate.view.DonateFragment
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
    private lateinit var linearLayoutManager: LinearLayoutManager

    var loading = false

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

    }

    override fun onResume() {
        super.onResume()

        postsViewmodel.getPosts()
    }

    override fun onPause() {
        super.onPause()
        postsViewmodel.page = -1
        postsAdapter.clear()
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

        linearLayoutManager = LinearLayoutManager(context, VERTICAL, false)

        postsAdapter = PostsAdapter(
            onClickListener = {
                (requireActivity() as MainActivity).replaceFragment(DonateFragment.newInstance())
            }
        )

        with(rvPosts) {
            setHasFixedSize(true)
            adapter = postsAdapter
            layoutManager = linearLayoutManager
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    val totalItemCount = recyclerView.layoutManager!!.itemCount
                    val lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition()

                    if (!loading && totalItemCount == lastVisibleItemPosition + 1) {
                        loading = true
                        postsViewmodel.getPosts()
                    }
                }
            })
        }
    }

    private fun subscribeUI() {
        with(postsViewmodel) {

            onLoadFinished.observe(requireActivity(), Observer {
                (requireActivity() as MainActivity).loadingBar.visibility = View.GONE
            })

            onError.observe(requireActivity(), Observer {

            })

            posts.observe(requireActivity(), Observer { newPosts ->
                postsAdapter.update(newPosts)
                loading = false
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PostsFragment()
    }
}