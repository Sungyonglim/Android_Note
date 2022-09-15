package com.example.android_notes.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.android_notes.databinding.ActivityMvvmcitiesBinding
import com.example.android_notes.mvvm.viewmodel.CityViewModel

class MVVMCitiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmcitiesBinding
    private val model: CityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmcitiesBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this) { city ->
            binding.cityImage.setImageDrawable(ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme))
            binding.tvCityName.text = city.name
            binding.tvCityPopulation.text = city.population.toString()
        }
    }
}