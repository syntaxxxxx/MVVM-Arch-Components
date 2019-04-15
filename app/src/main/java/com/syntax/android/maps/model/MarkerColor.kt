package com.syntax.android.maps.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.graphics.Color.GREEN
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

@Entity(tableName = "marker_color_table")
data class MarkerColor(@PrimaryKey val displayString: String) {

    companion object {
        const val RED_COLOR = "RED"
        const val GREEN_COLOR = "GREEN"
        const val BLUE_COLOR = "BLUE"

        fun getMarkerBitmapDescriptor(color: String): BitmapDescriptor =
                when (color) {
                    GREEN_COLOR -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)
                    BLUE_COLOR -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
                    else -> BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)
                }
    }
}
