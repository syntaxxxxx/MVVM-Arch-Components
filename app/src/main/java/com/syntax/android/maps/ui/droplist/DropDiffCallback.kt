package com.syntax.android.maps.ui.droplist

import android.support.v7.util.DiffUtil
import com.syntax.android.maps.model.Drop

class DropDiffCallback(private val oldDrops: List<Drop>,
                       private val newDrops: List<Drop>) : DiffUtil.Callback() {

    override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
        return oldDrops[p0].id == newDrops[p1].id
    }

    override fun getOldListSize() = oldDrops.size

    override fun getNewListSize() = newDrops.size

    override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
        val oldDrop = oldDrops[p0]
        val newDrop = newDrops[p1]

        return oldDrop.dropMessage == newDrop.dropMessage &&
                oldDrop.latLng == newDrop.latLng &&
                oldDrop.markerColor == newDrop.markerColor
    }
}