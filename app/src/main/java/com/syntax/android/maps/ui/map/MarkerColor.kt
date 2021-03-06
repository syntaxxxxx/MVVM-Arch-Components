
package com.syntax.android.maps.ui.map

import com.google.android.gms.maps.model.BitmapDescriptorFactory


enum class MarkerColor(val displayString: String) {
  RED("Red"), GREEN("Green"), BLUE("Blue");

  fun getMarkerBitmapDescriptor() =
      when (this) {
        MarkerColor.GREEN -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
        MarkerColor.BLUE -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
        else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
      }

  companion object {
    fun createMarkerColor(displayString: String) =
        when (displayString) {
          "Green" -> GREEN
          "Blue" -> BLUE
          else -> RED
        }
    fun createMarkerColor(markerColor: Int) =
        when (markerColor) {
          1 -> GREEN
          2 -> BLUE
          else -> RED
        }
  }
}