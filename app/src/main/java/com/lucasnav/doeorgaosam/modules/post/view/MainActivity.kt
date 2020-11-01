package com.lucasnav.doeorgaosam.modules.post.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.modules.donate.DonateFragment
import com.lucasnav.doeorgaosam.modules.faq.FaqFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(PostsFragment.newInstance())

        configClicks()
    }

    private fun configClicks() {
        buttonProfile.setOnClickListener {
//            replaceFragment(FaqFragment.newInstance())
        }

        buttonHome.setOnClickListener {
            replaceFragment(PostsFragment.newInstance())
        }

        buttonDonate.setOnClickListener {
            replaceFragment(DonateFragment.newInstance())
        }

        buttonFaq.setOnClickListener {
            replaceFragment(FaqFragment.newInstance())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment)
        fragmentTransaction.commit()
    }
}