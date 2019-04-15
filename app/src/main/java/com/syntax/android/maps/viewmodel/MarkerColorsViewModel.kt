package com.syntax.android.maps.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.syntax.android.maps.app.DataDropApplication

class MarkerColorsViewModel(application: Application) : AndroidViewModel(application) {

    private val markerColorDao = DataDropApplication.database.makerColorDao()
    private val allMarkerColors = markerColorDao.getAllMarkerColors()

    fun getMarkerColors() = allMarkerColors
}