
package com.syntax.android.maps.app

import com.syntax.android.maps.model.DropRepository
import com.syntax.android.maps.model.SQLiteRepository
import com.syntax.android.maps.ui.droplist.DropListContract
import com.syntax.android.maps.ui.droplist.DropListPresenter
import com.syntax.android.maps.ui.map.MapContract
import com.syntax.android.maps.ui.map.MapPresenter

object Injection {

  private fun provideDropRepository(): DropRepository = SQLiteRepository()

  fun provideMapPresenter(view: MapContract.View): MapContract.Presenter {
    return MapPresenter(provideDropRepository(), view)
  }

  fun provideDropListPresenter(view: DropListContract.View): DropListContract.Presenter {
    return DropListPresenter(provideDropRepository(), view)
  }
}