package com.platformscience.suitabilityscore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.platformscience.suitabilityscore.databinding.FragmentDriversBinding

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
		
		animateLoading()
		
		binding.rvDrivers.adapter = DriversAdapter()
		binding.rvDrivers.setHasFixedSize(true)
		
		viewModel.drivers.observe(viewLifecycleOwner) {
			binding.ivLoading.visibility = View.GONE
			
			val adapter = binding.rvDrivers.adapter as DriversAdapter
			adapter.submitList(it)
		}
	}
	
	private fun animateLoading() {
		val anim = RotateAnimation(
			0.0f,
			360.0f,
			Animation.RELATIVE_TO_SELF,
			0.5f,
			Animation.RELATIVE_TO_SELF,
			0.5f
		)
		
		anim.interpolator = LinearInterpolator()
		anim.repeatCount = Animation.INFINITE
		anim.duration = 250
		
		binding.ivLoading.startAnimation(anim)
	}
}