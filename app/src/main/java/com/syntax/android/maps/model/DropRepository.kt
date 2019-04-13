
package com.syntax.android.maps.model

interface DropRepository {
  fun addDrop(drop: Drop)
  fun getDrops(): List<Drop>
  fun clearDrop(drop: Drop)
  fun clearAllDrops()
}