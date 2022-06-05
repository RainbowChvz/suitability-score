package com.platformscience.suitabilityscore.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.platformscience.suitabilityscore.data.model.Driver
import com.platformscience.suitabilityscore.data.model.Shipment
import com.platformscience.suitabilityscore.data.source.LocalData
import com.platformscience.suitabilityscore.domain.Utils.Companion.asDrivers
import com.platformscience.suitabilityscore.domain.Utils.Companion.asShipments
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