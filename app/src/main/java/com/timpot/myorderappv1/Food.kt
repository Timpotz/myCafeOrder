package com.timpot.myorderappv1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val imageResId: Int,
    val name: String,
    val description: String,
    var price: Int = 0,
    var quantity: Int = 0,
    var totalPerItem: Int =0
) : Parcelable