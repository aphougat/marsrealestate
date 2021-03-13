package com.example.marsrealestate.dummy

data class RealEstateData(val id: Long, val url: String, val type: Type, val price : Long)

enum class Type{
    BUY, RENT
}