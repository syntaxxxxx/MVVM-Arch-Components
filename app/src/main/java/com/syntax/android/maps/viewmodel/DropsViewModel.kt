package com.syntax.android.maps.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.syntax.android.maps.app.Injection
import com.syntax.android.maps.model.Drop

class DropsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Injection.provideDropRepository()
    private val allDrops = repository.getDrops()

    fun getDrops() = allDrops

    fun insert(drop: Drop, listener: DropInsertListener) = repository.addDrop(drop, listener)

    fun clearAllDrops(listener: ClearAllDropListener) = repository.clearAllDrops(listener)

    fun clearDrops(drop: Drop, listener: ClearDropListener) = repository.clearDrop(drop, listener)
}