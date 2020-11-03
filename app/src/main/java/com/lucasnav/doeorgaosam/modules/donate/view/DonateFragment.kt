package com.lucasnav.doeorgaosam.modules.donate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.core.Helper
import com.lucasnav.doeorgaosam.modules.donate.networking.DonateNetworking
import com.lucasnav.doeorgaosam.modules.donate.repository.DonateRepository
import com.lucasnav.doeorgaosam.modules.donate.viewmodel.DonateViewModel
import com.lucasnav.doeorgaosam.modules.donate.viewmodel.DonateViewModelFactory
import com.lucasnav.doeorgaosam.modules.donate.model.Donate
import kotlinx.android.synthetic.main.fragment_donate.*

class DonateFragment : Fragment() {

    private lateinit var donateViewModel: DonateViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_donate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()

        subscribeUI()

        configDonateClick()
    }

    private fun configDonateClick() {

        buttonDonate.setOnClickListener {
            if (etAccount.text.toString().isNotEmpty()
                && etValue.text.toString().isNotEmpty()
                && etName.text.toString().isNotEmpty()
                && etNumber.text.toString().isNotEmpty()
                && etCvv.text.toString().isNotEmpty()
            ) {
                donateViewModel.postDonate(
                    Donate(
                        etName.text.toString(),
                        etValue.text.toString().toDouble()
                    )
                )
            } else {
                Toast.makeText(context, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun subscribeUI() {
        with(donateViewModel) {

            onLoadFinished.observe(requireActivity(), Observer {
//                progressBar.visibility = View.GONE
            })

            onError.observe(requireActivity(), Observer {
                Helper().catchErrorCode(
                    it,
                    requireContext(),
                    requireActivity()
                )
            })

            donate.observe(requireActivity(), Observer { donationResponse ->
                Toast.makeText(context, "Doação feita com sucesso!", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setupViewModel() {
        donateViewModel = ViewModelProvider(
            this,
            DonateViewModelFactory(
                DonateRepository(
                    DonateNetworking()
                )
            )
        ).get(DonateViewModel::class.java)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DonateFragment()
    }
}