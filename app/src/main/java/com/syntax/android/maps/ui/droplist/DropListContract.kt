
package com.syntax.android.maps.ui.droplist

import com.syntax.android.maps.model.Drop
import com.syntax.android.maps.ui.base.BasePresenter
import com.syntax.android.maps.ui.base.BaseView


interface DropListContract {
  interface View : BaseView<Presenter> {
    fun showDrops(drops: List<Drop>)
    fun removeDropAtPosition(position: Int)
  }

  interface Presenter : BasePresenter {
    fun getDrops(): List<Drop>
    fun deleteDropAtPosition(drop: Drop, position: Int)
  }
}