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
	
	private val _shipment = MutableLiveData<Shipment>()
	val shipment: LiveData<Shipment> = _shipment
	
	var shipments: MutableList<Shipment>? = null
	
	suspend fun getData() {
		withContext(Dispatchers.IO) {
			LocalData.getDataFromFile()
		}
		
		_drivers.value = LocalData.getResponse()?.drivers?.asDrivers()
	}
	
	suspend fun getShipmentByDriver(driverIndex: Int) {
		
		val driver = drivers.value?.get(driverIndex)
		if (driver?.shipment != null) {
			_shipment.value = driver.shipment!!
			return
		}
		
		var currentShipment: Shipment? = null
		var maxSuitableScore = 0f
		
		withContext(Dispatchers.IO) {
			if (shipments == null) {
				shipments = LocalData.getResponse()?.shipments?.asShipments()
			}
			
			for (i in shipments!!) {
				var suitableScore = when (i.streetName!!.length % 2) {
					0 -> driver!!.ssEvenVowel
					else -> driver!!.ssOddConsonant
				}
				
				val commonFactorsMap: HashMap<Int, Int> = HashMap()
				for (j in i.commonFactors!!) {
					commonFactorsMap[j] = 1
				}
				
				for (j in driver.commonFactors!!) {
					commonFactorsMap[j] = when (commonFactorsMap[j]) {
						0 -> 1
						else -> {
							suitableScore *= 1.5f
							break
						}
					}
				}
				
				if (suitableScore > maxSuitableScore) {
					maxSuitableScore = suitableScore
					currentShipment = i
				}
			}
		}
		
		_shipment.value = currentShipment!!
		shipments?.remove(currentShipment!!)
	}
	
	fun updateDriverWithShipment(driverIndex: Int) {
		_drivers.value?.get(driverIndex)?.shipment = shipment.value
	}
}