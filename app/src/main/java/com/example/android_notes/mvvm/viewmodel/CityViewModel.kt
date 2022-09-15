package com.example.android_notes.mvvm.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_notes.mvvm.model.City
import com.example.android_notes.mvvm.model.CityDataProvider

class CityViewModel: ViewModel() {

    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
    }

    fun getCityData(): LiveData<City> = cityData

    // 지연 시키는 메서드
    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({updateCity()},delay)
    }

    // 도시를 바꾸는 메서드
    private fun updateCity() {
        currentIndex++

        currentIndex %= cities.size

        cityData.value = cities[currentIndex]

        loop()

    }

}