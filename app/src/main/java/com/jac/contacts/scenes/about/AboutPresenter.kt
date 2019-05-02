package com.jac.contacts.scenes.about

import com.jac.contacts.service.WeatherClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AboutPresenter (val view: About.View): About.Presenter, CoroutineScope {


    override val coroutineContext: CoroutineContext = Dispatchers.Main + SupervisorJob()
    private var job: Job? = null

    override fun getWeather() {
        job = launch {
            val weather = withContext(Dispatchers.IO) { WeatherClient.instance.getCurrentWeatherData("-27.5375258", "-48.5070725") }
            view.loadWeather(weather)
        }
    }
}