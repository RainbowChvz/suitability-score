package com.platformscience.suitabilityscore.data.model

data class Driver(
	val name: String,
	
	// If street name length is even, count vowels in driver's name
	var ssEvenVowel: Float = 0f,
	// If street name length is odd, count consonants in driver's name
	var ssOddConsonant: Float = 0f,
	// Get common factors for driver's name length
	var commonFactors: List<Int>? = null,
	var shipment: Shipment? = null
)
