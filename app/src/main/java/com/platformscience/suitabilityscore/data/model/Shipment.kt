package com.platformscience.suitabilityscore.data.model

data class Shipment(
	val address: String,
	
	// Split street name for further operations
	var streetName: String? = null,
	// Get common factors for street name length
	var commonFactors: List<Int>? = null
)
