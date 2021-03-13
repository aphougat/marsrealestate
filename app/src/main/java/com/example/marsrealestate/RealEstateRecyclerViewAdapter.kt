package com.example.marsrealestate

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import android.widget.TextView
import com.example.marsrealestate.dummy.RealEstateData

import com.example.marsrealestate.dummy.RealEstateData.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class RealEstateRecyclerViewAdapter(val clickListener: RealEstateClickListener) : ListAdapter<RealEstateData, RealEstateViewHolder>(RealEstateDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RealEstateViewHolder {
       /* val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_overview, parent, false)*/
        return RealEstateViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RealEstateViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
       /* holder.idView.text = item.id
        holder.contentView.text = item.content*/
    }

}