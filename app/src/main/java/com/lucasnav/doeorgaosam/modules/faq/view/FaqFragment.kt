package com.lucasnav.doeorgaosam.modules.faq.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.core.Helper
import com.lucasnav.doeorgaosam.modules.MainActivity
import com.lucasnav.doeorgaosam.modules.faq.adapter.QuestionsAdapter
import com.lucasnav.doeorgaosam.modules.faq.networking.QuestionsNetworking
import com.lucasnav.doeorgaosam.modules.faq.repository.QuestionsRepository
import com.lucasnav.doeorgaosam.modules.faq.viewmodel.QuestionViewModel
import com.lucasnav.doeorgaosam.modules.faq.viewmodel.QuestionViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_faq.*

class FaqFragment : Fragment() {

    private lateinit var questionsViewModel: QuestionViewModel
    private lateinit var questionsAdapter: QuestionsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_faq, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setupViewModel()

        subscribeUI()

        questionsViewModel.getQuestions()
    }

    private fun setupRecyclerView() {
        questionsAdapter =
            QuestionsAdapter()

        with(rvFaq) {
            setHasFixedSize(true)
            adapter = questionsAdapter
        }
    }

    private fun setupViewModel() {
        questionsViewModel = ViewModelProvider(
            this,
            QuestionViewModelFactory(
                QuestionsRepository(
                    QuestionsNetworking()
                )
            )
        ).get(QuestionViewModel::class.java)
    }

    private fun subscribeUI() {
        with(questionsViewModel) {

            onLoadStarted.observe(requireActivity(), Observer {
                (requireActivity() as MainActivity).loadingBar.visibility = View.VISIBLE
            })

            onLoadFinished.observe(requireActivity(), Observer {
                (requireActivity() as MainActivity).loadingBar.visibility = View.GONE
            })

            onError.observe(requireActivity(), Observer {
                Helper().catchErrorCode(
                    it,
                    requireContext(),
                    requireActivity()
                )
            })

            questions.observe(requireActivity(), Observer { newQuestions ->
                questionsAdapter.update(newQuestions)
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FaqFragment()
    }
}