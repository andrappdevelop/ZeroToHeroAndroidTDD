package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    lateinit var viewModel: MainViewModel

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: SimpleService = retrofit.create(SimpleService::class.java)

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapper.Base(), Repository.Base(service, BASE_URL))
    }

    companion object {
        private const val BASE_URL =
            "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    }
}