package com.platformscience.suitabilityscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platformscience.suitabilityscore.data.RepositoryData
import kotlinx.coroutines.launch

class DriversViewModel : ViewModel() {
	
	private val repository = RepositoryData()
	val drivers = repository.drivers
	val shipment = repository.shipment
	
	init {
		getDataFromRepository()
	}
	
	private fun getDataFromRepository() {
		viewModelScope.launch {
			repository.getData()
		}
	}
	
	fun getShipment(driver: Int) {
		viewModelScope.launch {
			repository.getShipmentByDriver(driver)
		}
	}
}