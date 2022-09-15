package com.example.android_notes.mvvm.model

import com.example.android_notes.R

class CityDataProvider {
    private val cities = arrayListOf<City>()

    init {
        cities.add(City("방콕", R.drawable.bangkok, 14_600_000))
        cities.add(City("베이징", R.drawable.beijing, 21_540_000))
        cities.add(City("런던", R.drawable.london, 8_982_000))
        cities.add(City("뉴욕", R.drawable.newyork, 8_419_000))
        cities.add(City("파리", R.drawable.paris, 2_161_000))
        cities.add(City("리우데자네이루", R.drawable.rio, 6_780_000))
        cities.add(City("로마", R.drawable.rome, 2_873_000))
        cities.add(City("싱가포르", R.drawable.singapore, 5_686_000))
        cities.add(City("시드니", R.drawable.sydney, 5_312_000))
        cities.add(City("도쿄", R.drawable.tokyo, 13_960_000))
        cities.add(City("서울", R.drawable.seoul, 9_776_000))
    }

    fun getCities() = cities
}