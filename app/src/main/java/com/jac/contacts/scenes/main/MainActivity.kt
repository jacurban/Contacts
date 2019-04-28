package com.jac.contacts.scenes.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import com.jac.contacts.R
import com.jac.contacts.util.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Main.View {

    private lateinit var presenter: Main.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)

        val pagerAdapter = PagerAdapter(supportFragmentManager, this)
        viewPager?.adapter = pagerAdapter

        tab_layout.setupWithViewPager(viewPager)
        tab_layout.tabMode = TabLayout.MODE_FIXED
    }
}
