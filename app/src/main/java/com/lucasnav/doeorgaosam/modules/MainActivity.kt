package com.lucasnav.doeorgaosam.modules

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.lucasnav.doeorgaosam.R
import com.lucasnav.doeorgaosam.core.ACCESS_TOKEN
import com.lucasnav.doeorgaosam.modules.donate.view.DonateFragment
import com.lucasnav.doeorgaosam.modules.faq.view.FaqFragment
import com.lucasnav.doeorgaosam.modules.login.view.LoginActivity
import com.lucasnav.doeorgaosam.modules.post.view.NewPostFragment
import com.lucasnav.doeorgaosam.modules.post.view.PostsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarTitle.text = "Home"
        replaceFragment(PostsFragment.newInstance())

        configClicks()
    }

    private fun configClicks() {
        buttonProfile.setOnClickListener {
            Toast.makeText(baseContext, "Ops, tá mockado", Toast.LENGTH_SHORT).show()
        }

        buttonHome.setOnClickListener {
            toolbarTitle.text = "Home"
            replaceFragment(PostsFragment.newInstance())
        }

        buttonDonate.setOnClickListener {
            toolbarTitle.text = "Doe"
            replaceFragment(DonateFragment.newInstance())
        }

        buttonFaq.setOnClickListener {
            toolbarTitle.text = "FAQ"
            replaceFragment(FaqFragment.newInstance())
        }

        buttonNewPost.setOnClickListener {
            toolbarTitle.text = "Nova Publicação"
            replaceFragment(NewPostFragment.newInstance())
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.sair -> {
                    ACCESS_TOKEN = ""
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
    }

     fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, fragment)
         fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}