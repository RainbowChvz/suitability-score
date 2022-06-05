package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.platformscience.suitabilityscore.databinding.FragmentDriversBinding

class DriversFragment : Fragment() {
	
	private lateinit var binding: FragmentDriversBinding
	
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
}