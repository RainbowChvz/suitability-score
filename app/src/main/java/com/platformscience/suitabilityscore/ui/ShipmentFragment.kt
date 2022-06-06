package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.platformscience.suitabilityscore.databinding.FragmentShipmentBinding

class ShipmentFragment : Fragment() {
	
	private lateinit var binding: FragmentShipmentBinding
	
	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentShipmentBinding.inflate(
			inflater, container, false
		)
		return binding.root
	}
}