package com.lucasnav.doeorgaosam.modules.post.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.post.networking.PostsNetworking
import com.lucasnav.doeorgaosam.modules.post.repository.PostsRepository
import com.lucasnav.doeorgaosam.modules.post.viewmodel.PostViewModelFactory
import com.lucasnav.doeorgaosam.modules.post.viewmodel.PostsViewModel
import kotlinx.android.synthetic.main.fragment_donate.*
import kotlinx.android.synthetic.main.fragment_new_post.*

class NewPostFragment : Fragment() {

    private lateinit var postsViewmodel: PostsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_post, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

//        subscribeUI()

        buttonPublicar.setOnClickListener {
            if (etContent.text.toString().isNotEmpty()
                && etUrl.text.toString().isNotEmpty()
            ) {

            } else {
                Toast.makeText(context, "preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupViewModel() {
        postsViewmodel = ViewModelProvider(
            this,
            PostViewModelFactory(
                PostsRepository(PostsNetworking())
            )
        ).get(PostsViewModel::class.java)
    }

//    private fun subscribeUI() {
//        with(postsViewmodel) {
//
//            onLoadFinished.observe(requireActivity(), Observer {
//                (requireActivity() as MainActivity).loadingBar.visibility = View.GONE
//            })
//
//            onError.observe(requireActivity(), Observer {
//
//            })
//
//            posts.observe(requireActivity(), Observer { newPosts ->
//                postsAdapter.update(newPosts)
//                loading = false
//            })
//        }
//    }

    companion object {
        @JvmStatic
        fun newInstance() = NewPostFragment()
    }
}