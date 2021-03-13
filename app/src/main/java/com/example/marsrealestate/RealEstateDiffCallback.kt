package com.example.marsrealestate

import androidx.recyclerview.widget.DiffUtil
import com.example.marsrealestate.dummy.RealEstateData

class RealEstateDiffCallback : DiffUtil.ItemCallback<RealEstateData>() {

    override fun areItemsTheSame(oldItem: RealEstateData, newItem: RealEstateData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RealEstateData, newItem: RealEstateData): Boolean {
        oldItem == newItem
    }

    override fun getChangePayload(oldItem: RealEstateData, newItem: RealEstateData): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}