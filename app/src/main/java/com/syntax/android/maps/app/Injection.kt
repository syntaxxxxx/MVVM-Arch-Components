
package com.syntax.android.maps.app

import com.syntax.android.maps.model.DropRepository
import com.syntax.android.maps.model.RoomRepository

object Injection {

  fun provideDropRepository(): DropRepository = RoomRepository()

}