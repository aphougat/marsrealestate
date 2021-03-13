package com.example.marsrealestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.marsrealestate.databinding.FragmentOverviewListBinding
import com.example.marsrealestate.dummy.RealEstateData

/**
 * A fragment representing a list of Items.
 */
class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentOverviewListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview_list, container, false)

        val manager = GridLayoutManager(activity, 2)
        binding.list.layoutManager = manager
        binding.setLifecycleOwner(this)
        val adapter = RealEstateRecyclerViewAdapter(RealEstateClickListener { id ->
            /*Toast.makeText(context, "${nightId}", Toast.LENGTH_LONG).show()*/
           /* val action = SleepTrackerFragmentDirections.actionSleepTrackerFragmentToSleepDetailsFragment(nightId)
            NavHostFragment.findNavController(this).navigate(action)*/
        })
        binding.list.adapter = adapter
        //adapter.data = viewModel.sleepRecords.value!!
       /* viewModel.sleepRecords.observe(viewLifecycleOwner, Observer { list -> adapter.addHeaderAndSubmitList( list) })
        binding.viewModel = viewModel*/
        return binding.root

    }

}