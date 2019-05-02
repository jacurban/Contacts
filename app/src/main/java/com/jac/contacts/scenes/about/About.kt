package com.jac.contacts.scenes.about

import com.jac.contacts.model.WeatherResponse
import com.jac.contacts.scenes.Scene

interface About{
    interface View: Scene.View {
        fun loadWeather(weather: WeatherResponse?)
    }
    interface Presenter: Scene.Presenter {
        fun getWeather()
    }
}