package com.syntax.android.maps.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import java.util.*

@Entity(tableName = "drop_table")
data class Drop(val latLng: LatLng,
                val dropMessage: String,
                @PrimaryKey val id: String = UUID.randomUUID().toString(),
                val markerColor: Int = 0) {

    fun latLngString() = "%.6f, %.6f".format(latLng.latitude, latLng.longitude)
}