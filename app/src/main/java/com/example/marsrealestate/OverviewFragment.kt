package com.example.marsrealestate

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.marsrealestate.databinding.FragmentOverviewListBinding
import com.example.marsrealestate.dummy.RealEstateData
import kotlinx.android.synthetic.main.fragment_overview_list.*

/**
 * A fragment representing a list of Items.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentOverviewListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview_list, container, false)

        val manager = GridLayoutManager(activity, 2)
        binding.list.layoutManager = manager
        binding.lifecycleOwner = this
        val adapter = RealEstateRecyclerViewAdapter(RealEstateClickListener { realEstateData ->
            /*Toast.makeText(context, "${nightId}", Toast.LENGTH_LONG).show()*/
            val action = OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(realEstateData)
            NavHostFragment.findNavController(this).navigate(action)
        })
        binding.list.adapter = adapter
        setHasOptionsMenu(true)
        viewModel.response.observe(viewLifecycleOwner, Observer { list ->  adapter.submitList( list) })
        binding.viewModel = viewModel
       /* viewModel.sleepRecords.observe(viewLifecycleOwner, Observer { list -> adapter.addHeaderAndSubmitList( list) })
        binding.viewModel = viewModel*/
        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when (item.itemId) {
                R.id.rent -> RealEstateApiFilter.SHOW_RENT
                R.id.buy -> RealEstateApiFilter.SHOW_BUY
                else -> RealEstateApiFilter.SHOW_ALL
            }
        )
        return true
    }

}