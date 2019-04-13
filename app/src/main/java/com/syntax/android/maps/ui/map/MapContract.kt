
package com.syntax.android.maps.ui.map

import com.syntax.android.maps.model.Drop
import com.syntax.android.maps.ui.base.BasePresenter
import com.syntax.android.maps.ui.base.BaseView


interface MapContract {
  interface View : BaseView<Presenter> {
    fun showDrop(drop: Drop)
    fun showDrops(drops: List<Drop>)
  }

  interface Presenter : BasePresenter {
    fun getDrops(): List<Drop>
    fun addDrop(drop: Drop)
    fun clearAllDrops()
    fun saveMarkerColor(markerColor: String)
    fun getMarkerColor(): String
    fun saveMapType(mapType: String)
    fun getMapType(): String
  }
}