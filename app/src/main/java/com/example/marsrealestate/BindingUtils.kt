package com.example.marsrealestate

import android.graphics.BitmapFactory
import android.net.Uri
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.marsrealestate.dummy.RealEstateData
import java.net.URL


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
        var url = URL(item.img_src)
        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
        setImageBitmap(bmp)
    }
}