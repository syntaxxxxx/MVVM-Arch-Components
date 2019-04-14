package com.syntax.android.maps.app

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.syntax.android.maps.model.DropDatabase


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
                "drop_database").build()
    }
}