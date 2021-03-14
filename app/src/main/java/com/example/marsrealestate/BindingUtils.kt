package com.example.marsrealestate

import android.graphics.BitmapFactory
import android.net.Uri
import android.view.View
import android.webkit.URLUtil
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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
fun setRealEstateImage(imageView: ImageView,imageUrl: String?)
{
    imageUrl?.let {
        val uri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context).load(uri).apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)).into(imageView)
    }
}

@BindingAdapter("apiStatus")
fun bindApiStatus(imageView: ImageView, status: Status?)
{
    when(status){
        Status.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }
        Status.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }
        Status.DONE -> {
            imageView.visibility = View.GONE
        }
    }
}