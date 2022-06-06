package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.platformscience.suitabilityscore.databinding.FragmentDriversBinding
import com.platformscience.suitabilityscore.domain.Utils.Companion.loadingAnim

class DriversFragment : Fragment() {
	
	private lateinit var binding: FragmentDriversBinding
	private val viewModel: DriversViewModel by viewModels()
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		
		binding = FragmentDriversBinding.inflate(
			inflater,
			container,
			false
		)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding.ivLoading.startAnimation(loadingAnim())
		
		binding.rvDrivers.adapter = DriversAdapter()
		binding.rvDrivers.setHasFixedSize(true)
		
		viewModel.drivers.observe(viewLifecycleOwner) {
			binding.ivLoading.visibility = View.GONE
			
			val adapter = binding.rvDrivers.adapter as DriversAdapter
			adapter.submitList(it)
		}
	}
}