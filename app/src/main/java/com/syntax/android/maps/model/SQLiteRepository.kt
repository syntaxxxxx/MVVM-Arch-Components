package com.syntax.android.maps.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.syntax.android.maps.app.DataDropApplication
import com.syntax.android.maps.model.DropDbSchema.DropTable
import android.content.ContentValues
import android.util.Log
import com.syntax.android.maps.viewmodel.ClearAllDropListener
import com.syntax.android.maps.viewmodel.ClearDropListener
import com.syntax.android.maps.viewmodel.DropInsertListener
import java.io.IOException


class SQLiteRepository : DropRepository {

    private val database = DropDbHelper(DataDropApplication.getAppContext()).writableDatabase

    override fun addDrop(drop: Drop, listener: DropInsertListener) {
        val contentValues = getDropContentValues(drop)
        val result = database.insert(DropTable.NAME, null, contentValues)
        if (result != -1L) {
            listener.dropInserted(drop)
        }
    }

    override fun getDrops(): LiveData<List<Drop>> {
        val liveData = MutableLiveData<List<Drop>>()
        val drops = mutableListOf<Drop>()

        val cursor = queryDrops(null, null)

        try {
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                drops.add(cursor.getDrop())
                cursor.moveToNext()
            }
        } catch (e: IOException) {
            Log.e("SQLiteRepository", "Error reading drops")
        } finally {
            cursor.close()
        }

        liveData.value = drops

        return liveData
    }

    override fun clearDrop(drop: Drop, listener: ClearDropListener) {
        val result = database.delete(
                DropTable.NAME,
                DropTable.Columns.ID + " = ?",
                arrayOf(drop.id)
        )
        if (result != 0) {
            listener.dropCleared(drop)
        }
    }

    override fun clearAllDrops(listener: ClearAllDropListener) {
        val result = database.delete(DropTable.NAME, null, null)
        if (result != 0) {
            listener.allDropCleared()
        }
    }

    private fun getDropContentValues(drop: Drop): ContentValues {
        val contentValues = ContentValues()
        contentValues.put(DropTable.Columns.ID, drop.id)
        contentValues.put(DropTable.Columns.LATITUDE, drop.latLng.latitude)
        contentValues.put(DropTable.Columns.LONGITUDE, drop.latLng.longitude)
        contentValues.put(DropTable.Columns.DROP_MESSAGE, drop.dropMessage)
        contentValues.put(DropTable.Columns.MARKER_COLOR, drop.markerColor)
        return contentValues
    }

    private fun queryDrops(where: String?, whereArgs: Array<String>?): DropCursorWrapper {
        val cursor = database.query(
                DropTable.NAME,
                null, // select all columns
                where,
                whereArgs,
                null, // groupBy
                null, // having
                null  // orderBy
        )

        return DropCursorWrapper(cursor)
    }
}