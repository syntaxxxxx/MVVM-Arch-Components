
package com.syntax.android.maps.app

import android.app.Application
import android.content.Context


class DataDropApplication : Application() {

  companion object {
    private lateinit var instance: DataDropApplication

    fun getAppContext(): Context = instance.applicationContext
  }

  override fun onCreate() {
    instance = this
    super.onCreate()
  }
}