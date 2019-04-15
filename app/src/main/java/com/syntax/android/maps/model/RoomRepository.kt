package com.syntax.android.maps.model

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Delete
import android.os.AsyncTask
import com.syntax.android.maps.app.DataDropApplication

class RoomRepository : DropRepository {

    private val dropDao: DropDao = DataDropApplication.database.dropDao()
    private val allDrops: LiveData<List<Drop>>

    init {
        allDrops = dropDao.getAllDrops()
    }

    override fun addDrop(drop: Drop) {
        InsertAsyncTask(dropDao).execute(drop)
    }

    override fun getDrops() = allDrops

    override fun clearDrop(drop: Drop) {
        DeleteAsyncTask(dropDao).execute(drop)
    }

    override fun clearAllDrops() {
        val dropArray = allDrops.value?.toTypedArray()
        if (dropArray != null) {
            DeleteAsyncTask(dropDao).execute(*dropArray)
        }
    }

    private class InsertAsyncTask internal constructor(private val dao: DropDao) : AsyncTask<Drop, Void, Void>() {
        override fun doInBackground(vararg drop: Drop): Void? {
            dao.insert(drop[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: DropDao) : AsyncTask<Drop, Void, Void>() {
        override fun doInBackground(vararg drop: Drop): Void? {
            dao.clearDrops(*drop)
            return null
        }
    }
}