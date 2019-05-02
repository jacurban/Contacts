package com.jac.contacts.scenes.about

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jac.contacts.R
import com.jac.contacts.model.WeatherResponse
import kotlinx.android.synthetic.main.fragment_about.*


class AboutFragment : Fragment(), About.View {

    override fun loadWeather(weather: WeatherResponse?) {
        weather?.let {
            val temperature = it.main?.temp
            Toast.makeText(activity, "temperatura: ${temperature?.toString()}", Toast.LENGTH_SHORT).show()
        } ?: run {
            Toast.makeText(activity, "ERROR", Toast.LENGTH_LONG).show()
        }

        tempPB?.visibility = View.GONE
        tempBTN?.isClickable = true
    }

    private lateinit var presenter: About.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = AboutPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tempBTN?.setOnClickListener {
            tempPB?.visibility = View.VISIBLE
            tempBTN.isClickable = false
            presenter.getWeather()
        }
    }
}
