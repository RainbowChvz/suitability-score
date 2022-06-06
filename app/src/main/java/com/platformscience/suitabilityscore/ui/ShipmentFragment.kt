package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.platformscience.suitabilityscore.R
import com.platformscience.suitabilityscore.databinding.FragmentShipmentBinding
import com.platformscience.suitabilityscore.domain.Utils.Companion.loadingAnim

class ShipmentFragment : Fragment() {
	
	private lateinit var binding: FragmentShipmentBinding
	private val viewModel: DriversViewModel by activityViewModels()
	
	private var currentDriver: String? = null
	private var currentPosition = -1
	
	companion object {
		const val DRIVER = "driver"
		const val POSITION = "position"
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		arguments?.let {
			currentDriver = it.getString(DRIVER)
			currentPosition = it.getInt(POSITION)
		}
	}
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentShipmentBinding.inflate(
			inflater, container, false
		)
		return binding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		
		binding.apply {
			tvShipmentTitle.text = getString(R.string.shipment_header, currentDriver)
			tvDriver.text = currentDriver
			ivLoading.startAnimation(loadingAnim())
		}
		
		viewModel.getShipment(currentPosition)
		viewModel.shipment.observe(viewLifecycleOwner) { shipment ->
			binding.ivLoading.clearAnimation()
			binding.ivLoading.visibility = View.INVISIBLE
			
			binding.tvShipment.text = shipment.address
			
			viewModel.updateDriver(currentPosition)
		}
	}
}