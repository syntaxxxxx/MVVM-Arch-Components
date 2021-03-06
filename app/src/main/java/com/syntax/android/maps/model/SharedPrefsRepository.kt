
package com.syntax.android.maps.model

import android.content.Context
import com.google.gson.Gson
import com.syntax.android.maps.app.DataDropApplication


object SharedPrefsRepository : DropRepository {

  private val gson = Gson()

  private const val SHARED_PREFS_REPOSITORY = "SHARED_PREFS_REPOSITORY"

  private fun sharedPrefs() =
    DataDropApplication.getAppContext().getSharedPreferences(SHARED_PREFS_REPOSITORY, Context.MODE_PRIVATE)

  override fun addDrop(drop: Drop) {
    sharedPrefs().edit().putString(drop.id, gson.toJson(drop)).apply()
  }

  override fun getDrops(): List<Drop> {
    return sharedPrefs().all.keys
        .map { sharedPrefs().getString(it, "") }
        .filterNot { it.isNullOrBlank() }
        .map { gson.fromJson(it, Drop::class.java) }
  }

  override fun clearDrop(drop: Drop) {
    sharedPrefs().edit().remove(drop.id).apply()
  }

  override fun clearAllDrops() {
    sharedPrefs().edit().clear().apply()
  }
}