package com.example.marsrealestate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.marsrealestate.databinding.FragmentDetailsBinding

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(inflater, R.layout.fragment_details,container, false )

        val payload = DetailFragmentArgs.fromBundle(arguments!!).payload
        binding.realEstate = payload
        return binding.root
    }
}