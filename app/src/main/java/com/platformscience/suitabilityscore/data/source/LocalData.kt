package com.platformscience.suitabilityscore.data.source

import com.platformscience.suitabilityscore.data.model.ResponseData
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object LocalData {
	
	private var response: ResponseData? = null
	
	private val jsonLocalData = "{\n" +
			"  \"shipments\": [\n" +
			"    \"215 Osinski Manors\",\n" +
			"    \"9856 Marvin Stravenue\",\n" +
			"    \"7127 Kathlyn Ferry\",\n" +
			"    \"987 Champlin Lake\",\n" +
			"    \"63187 Volkman Garden Suite 447\",\n" +
			"    \"75855 Dessie Lights\",\n" +
			"    \"1797 Adolf Island Apt. 744\",\n" +
			"    \"2431 Lindgren Corners\",\n" +
			"    \"8725 Aufderhar River Suite 859\",\n" +
			"    \"79035 Shanna Light Apt. 322\"\n" +
			"  ],\n" +
			"  \"drivers\": [\n" +
			"    \"Everardo Welch\",\n" +
			"    \"Orval Mayert\",\n" +
			"    \"Howard Emmerich\",\n" +
			"    \"Izaiah Lowe\",\n" +
			"    \"Monica Hermann\",\n" +
			"    \"Ellis Wisozk\",\n" +
			"    \"Noemie Murphy\",\n" +
			"    \"Cleve Durgan\",\n" +
			"    \"Murphy Mosciski\",\n" +
			"    \"Kaiser Sose\"\n" +
			"  ]\n" +
			"}"
	
	fun getDataFromFile() {
//		val jsonLocalData = resources.openRawResource(R.raw.data).bufferedReader().use {
//			it.readText()
//		}
		
		val moshi = Moshi.Builder()
			.add(KotlinJsonAdapterFactory())
			.build()
		val jsonAdapter: JsonAdapter<ResponseData> = moshi.adapter(ResponseData::class.java)
		
		response = jsonAdapter.fromJson(jsonLocalData)
	}
	
	fun getResponse(): ResponseData? = response
}