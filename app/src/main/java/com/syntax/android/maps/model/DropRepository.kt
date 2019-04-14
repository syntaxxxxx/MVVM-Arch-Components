package com.syntax.android.maps.model

import android.arch.lifecycle.LiveData

interface DropRepository {
    fun addDrop(drop: Drop)
    fun getDrops(): LiveData<List<Drop>>
    fun clearDrop(drop: Drop)
    fun clearAllDrops()
}