package com.example.marsrealestate.dummy

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RealEstateData(
    val id: Long,
    val img_src: String,
    val type: String,
    val price: Long
) : Parcelable{ }