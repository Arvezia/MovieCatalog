package com.naufaldy.moviecatalog.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ModelData (
    var id: Int? = null,
    var title : String? = null,
    var synopsis: String? = null,
    var poster:String? = null
    ): Parcelable