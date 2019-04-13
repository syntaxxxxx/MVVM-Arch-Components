@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.syntax.android.maps.model

import android.preference.PreferenceManager
import com.syntax.android.maps.app.DataDropApplication


object MapPrefs {

  private const val KEY_MARKER_COLOR = "KEY_MARKER_COLOR"

  private const val KEY_MAP_TYPE = "KEY_MAP_TYPE"

  private fun sharedPrefs() = PreferenceManager.getDefaultSharedPreferences(DataDropApplication.getAppContext())

  fun saveMarkerColor(markerColor: String) {
    val editor = sharedPrefs().edit()
    editor.putString(KEY_MARKER_COLOR, markerColor).apply()
  }

  fun getMarkerColor(): String = sharedPrefs().getString(KEY_MARKER_COLOR, "Red")

  fun saveMapType(mapType: String) {
    sharedPrefs().edit().putString(KEY_MAP_TYPE, mapType).apply()
  }

  fun getMapType(): String = sharedPrefs().getString(KEY_MAP_TYPE, "Normal")
}