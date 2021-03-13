package com.example.marsrealestate

import com.example.marsrealestate.dummy.RealEstateData

class RealEstateClickListener (val clickListener : (id : Long) -> Unit ) {
    fun onClick(realEstateData: RealEstateData) = clickListener(realEstateData.id)
}