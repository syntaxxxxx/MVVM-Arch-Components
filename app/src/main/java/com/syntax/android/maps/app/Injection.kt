
package com.syntax.android.maps.app

import com.syntax.android.maps.model.DropRepository
import com.syntax.android.maps.model.SQLiteRepository

object Injection {

  fun provideDropRepository(): DropRepository = SQLiteRepository()

}