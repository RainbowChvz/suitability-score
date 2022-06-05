package com.platformscience.suitabilityscore.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.platformscience.suitabilityscore.data.model.Driver
import com.platformscience.suitabilityscore.data.model.Shipment
import com.platformscience.suitabilityscore.data.source.LocalData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryData {
	
	private val _drivers = MutableLiveData<List<Driver>>()
	val drivers: LiveData<List<Driver>> = _drivers
	
	private val _shipments = MutableLiveData<List<Shipment>>()
	val shipments: LiveData<List<Shipment>> = _shipments
	
	suspend fun getData() {
		withContext(Dispatchers.IO) {
			LocalData.getDataFromFile()
		}
		
		_drivers.value = LocalData.getResponse()?.drivers?.asDrivers()
		_shipments.value = LocalData.getResponse()?.shipments?.asShipments()
	}
}

private fun List<String>.asDrivers(): List<Driver> {
	
	val list = mutableListOf<Driver>()
	for (i in this) {
		list.add(
			Driver(i)
		)
	}
	
	return list
}

private fun List<String>.asShipments(): List<Shipment> {
	
	val list = mutableListOf<Shipment>()
	for (i in this) {
		list.add(
			Shipment(i)
		)
	}
	
	return list
}
