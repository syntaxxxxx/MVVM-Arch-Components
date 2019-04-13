
package com.syntax.android.maps.ui.map

import com.syntax.android.maps.model.Drop
import com.syntax.android.maps.model.DropRepository
import com.syntax.android.maps.model.MapPrefs


class MapPresenter(private val repo: DropRepository, private val view: MapContract.View) : MapContract.Presenter {

  override fun start() {
    view.showDrops(getDrops())
  }

  override fun getDrops(): List<Drop> {
    return repo.getDrops()
  }

  override fun addDrop(drop: Drop) {
    repo.addDrop(drop)
    view.showDrop(drop)
  }

  override fun clearAllDrops() {
    repo.clearAllDrops()
  }

  override fun saveMarkerColor(markerColor: String) {
    MapPrefs.saveMarkerColor(markerColor)
  }

  override fun getMarkerColor(): String = MapPrefs.getMarkerColor()

  override fun saveMapType(mapType: String) {
    MapPrefs.saveMapType(mapType)
  }

  override fun getMapType(): String = MapPrefs.getMapType()
}
