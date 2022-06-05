package com.platformscience.suitabilityscore.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.platformscience.suitabilityscore.data.model.Driver
import com.platformscience.suitabilityscore.databinding.ItemDriverLinearBinding

class DriversAdapter : ListAdapter<Driver, DriverViewHolder>(DiffCallback) {
	object DiffCallback: DiffUtil.ItemCallback<Driver>() {
		override fun areItemsTheSame(
			oldItem: Driver,
			newItem: Driver
		): Boolean {
			return false
		}
		
		override fun areContentsTheSame(
			oldItem: Driver,
			newItem: Driver
		): Boolean {
			return false
		}
		
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
		return DriverViewHolder(
			ItemDriverLinearBinding.inflate(
				LayoutInflater.from(
					parent.context
				)
			)
		)
	}
	
	override fun onBindViewHolder(holder: DriverViewHolder, position: Int) {
		val driver = getItem(position)
		holder.bind(driver)
	}
}

class DriverViewHolder(val binding: ItemDriverLinearBinding) : RecyclerView.ViewHolder(binding.root) {
	
	fun bind(current: Driver) {
		binding.tvDriverName.text = current.name
	}
}
