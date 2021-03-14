package com.example.marsrealestate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrealestate.databinding.FragmentOverviewBinding
import com.example.marsrealestate.dummy.RealEstateData

class RealEstateViewHolder private constructor(val binding: FragmentOverviewBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(parent: ViewGroup) : RealEstateViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = FragmentOverviewBinding.inflate(layoutInflater, parent, false)
            return RealEstateViewHolder(binding)
        }
    }

    fun bind(
        item: RealEstateData,
        clickListener: RealEstateClickListener
    ) {
        binding.realEstate = item
        binding.clickListener = clickListener
        binding.executePendingBindings()

    }

}