package com.lucasnav.doeorgaosam.modules.faq

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
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
        questionsAdapter = QuestionsAdapter()

        with(rvFaq) {
            setHasFixedSize(true)
            adapter = questionsAdapter
        }
    }

    private fun setupViewModel() {
        questionsViewModel = ViewModelProvider(
            this,
            QuestionViewModelFactory(
                QuestionsRepository(QuestionsNetworking())
            )
        ).get(QuestionViewModel::class.java)
    }

    private fun subscribeUI() {
        with(questionsViewModel) {

            onLoadFinished.observe(requireActivity(), Observer {
                progressBar2.visibility = View.GONE
            })

            onError.observe(requireActivity(), Observer {

            })

            questions.observe(requireActivity(), Observer { newQuestions ->
                questionsAdapter.update(newQuestions)
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FaqFragment()
    }
}