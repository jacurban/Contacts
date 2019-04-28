package com.jac.contacts.scenes.about

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jac.contacts.R


class AboutFragment : Fragment(), About.View {

    private lateinit var presenter: About.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AboutPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_about, container, false)
        return v
    }

}
