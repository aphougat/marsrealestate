package com.example.marsrealestate

import com.example.marsrealestate.dummy.RealEstateData

class RealEstateClickListener (val clickListener : (realEstateData: RealEstateData) -> Unit ) {
    fun onClick(realEstateData: RealEstateData) = clickListener(realEstateData)
}