package com.syntax.android.maps.model

import android.arch.persistence.room.*

@Database(entities = [(Drop::class)], version = 1)
@TypeConverters(LatLngConverter::class)
abstract class DropDatabase : RoomDatabase() {

    abstract fun dropDao(): DropDao

}