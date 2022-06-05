package com.platformscience.suitabilityscore.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platformscience.suitabilityscore.data.RepositoryData
import kotlinx.coroutines.launch

class DriversViewModel : ViewModel() {
	
	private val repository = RepositoryData()
	val drivers = repository.drivers
	
	init {
		getDataFromRepository()
	}
	
	private fun getDataFromRepository() {
		viewModelScope.launch {
			repository.getData()
		}
	}
}