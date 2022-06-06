package com.platformscience.suitabilityscore.ui.shipment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platformscience.suitabilityscore.data.RepositoryData
import kotlinx.coroutines.launch

class ShipmentViewModel : ViewModel() {
	
	val shipment = RepositoryData.shipment
	
	fun getShipment(driver: Int) {
		viewModelScope.launch {
			RepositoryData.getShipmentByDriver(driver)
		}
	}
	
	fun updateDriver(driver: Int) {
		RepositoryData.updateDriverWithShipment(driver)
	}
}