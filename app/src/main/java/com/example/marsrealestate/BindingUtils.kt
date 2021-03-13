package com.example.marsrealestate

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marsrealestate.dummy.RealEstateData

@BindingAdapter("realEstateType")
fun TextView.setRealEstateType(item: RealEstateData?)
{
    item?.let{
        text = item.type.toString()
    }
}

@BindingAdapter("realEstatePrice")
fun TextView.setRealEstatePrice(item: RealEstateData?)
{
    item?.let {
        text = item.price.toString()
    }
}

@BindingAdapter("realEstateImage")
fun ImageView.setRealEstateImage(item: RealEstateData?)
{
    item?.let {
        setImageURI(Uri.parse(item.url))
    }
}