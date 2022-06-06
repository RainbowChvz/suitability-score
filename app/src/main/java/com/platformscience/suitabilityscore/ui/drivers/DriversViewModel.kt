package com.platformscience.suitabilityscore.ui.drivers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platformscience.suitabilityscore.data.RepositoryData
import kotlinx.coroutines.launch

class DriversViewModel : ViewModel() {
	
	val drivers = RepositoryData.drivers
	
	init {
		getDataFromRepository()
	}
	
	private fun getDataFromRepository() {
		viewModelScope.launch {
			RepositoryData.getData()
		}
	}
}