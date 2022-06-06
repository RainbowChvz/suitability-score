package com.platformscience.suitabilityscore.data.source

import com.platformscience.suitabilityscore.R
import com.platformscience.suitabilityscore.data.model.ResponseData
import com.platformscience.suitabilityscore.domain.Utils
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object LocalData {
	
	private var response: ResponseData? = null
	
	fun getDataFromFile() {
		
		if (response != null) {
			return
		}
		
		val jsonLocalData = Utils.getContext().resources.openRawResource(R.raw.data)
			.bufferedReader().use {
			it.readText()
		}
		
		val moshi = Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.build()
		val jsonAdapter: JsonAdapter<ResponseData> = moshi.adapter(ResponseData::class.java)
		
		response = jsonAdapter.fromJson(jsonLocalData)
	}
	
	fun getResponse(): ResponseData? = response
}