package com.syntax.android.maps.model

import android.arch.lifecycle.LiveData
import com.syntax.android.maps.viewmodel.ClearAllDropListener
import com.syntax.android.maps.viewmodel.ClearDropListener
import com.syntax.android.maps.viewmodel.DropInsertListener

interface DropRepository {
    fun addDrop(drop: Drop, listener: DropInsertListener)
    fun getDrops(): LiveData<List<Drop>>
    fun clearDrop(drop: Drop, listener: ClearDropListener)
    fun clearAllDrops(listener: ClearAllDropListener)
}