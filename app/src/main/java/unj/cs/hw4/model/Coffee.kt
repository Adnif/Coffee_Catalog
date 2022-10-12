package unj.cs.hw4.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffee(
    val title: Int,
    val drawable: Int,
    val shortDescription: Int,
    val longDescription: Int,
    var favorite: Boolean = false
) : Parcelable
