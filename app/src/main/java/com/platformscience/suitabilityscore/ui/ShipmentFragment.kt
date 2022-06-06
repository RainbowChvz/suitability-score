package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.platformscience.suitabilityscore.R
import com.platformscience.suitabilityscore.databinding.FragmentShipmentBinding
import com.platformscience.suitabilityscore.domain.Utils.Companion.loadingAnim

class ShipmentFragment : Fragment() {
	
	private lateinit var binding: FragmentShipmentBinding
	
	private var currentDriver: String? = null
	
	companion object {
		const val DRIVER = "driver"
	}
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		arguments?.let {
			currentDriver = it.getString(DRIVER)
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
		
		binding.tvShipmentTitle.text = getString(R.string.shipment_header, currentDriver)
		binding.tvDriver.text = currentDriver
		binding.ivLoading.startAnimation(loadingAnim())
	}
}