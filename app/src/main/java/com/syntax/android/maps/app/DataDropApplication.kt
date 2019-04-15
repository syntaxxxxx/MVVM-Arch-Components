package com.syntax.android.maps.app

import android.app.Application
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask
import com.syntax.android.maps.model.Drop
import com.syntax.android.maps.model.DropDatabase
import com.syntax.android.maps.model.MarkerColor
import com.syntax.android.maps.model.MarkerColorDao


class DataDropApplication : Application() {

    companion object {

        lateinit var database: DropDatabase

        private lateinit var instance: DataDropApplication

        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()

        database = Room.databaseBuilder(
                this, DropDatabase::class.java,
                "drop_database")
                .addCallback(roomDatabaseCallbacks)
                .build()
    }

    private val roomDatabaseCallbacks = object : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            PopulateBdAsync(DataDropApplication.database).execute()
        }
    }

    private class PopulateBdAsync(db: DropDatabase) : AsyncTask<Void, Void, Void>() {

        private val markerColorDao: MarkerColorDao = db.makerColorDao()

        override fun doInBackground(vararg params: Void): Void? {

            var markerColor = MarkerColor(MarkerColor.RED_COLOR)
            markerColorDao.insert(markerColor)

            markerColor = MarkerColor(MarkerColor.GREEN_COLOR)
            markerColorDao.insert(markerColor)

            markerColor = MarkerColor(MarkerColor.BLUE_COLOR)
            markerColorDao.insert(markerColor)

            return null
        }
    }
}