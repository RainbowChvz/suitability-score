package com.platformscience.suitabilityscore.domain

import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.platformscience.suitabilityscore.data.model.*

class Utils {
	
	companion object {
		fun List<String>.asDrivers(): List<Driver> {
			
			val list = mutableListOf<Driver>()
			for (i in this) {
				list.add(
					Driver(i)
						.getSsValues()
						.getCommonFactors()
				)
			}
			
			return list
		}
		
		fun List<String>.asShipments(): List<Shipment> {
			
			val list = mutableListOf<Shipment>()
			for (i in this) {
				list.add(
					Shipment(i)
						.getStreetName()
						.getCommonFactors()
				)
			}
			
			return list
		}
		
		fun Driver.getSsValues(): Driver {
			for (i in name.lowercase()) {
				when (i) {
					'a','e','i','o','u' -> ssEvenVowel++
					in 'a'..'z' -> ssOddConsonant++
				}
			}
			ssEvenVowel *= 1.5f
			
			return this
		}
		
		fun Driver.getCommonFactors(): Driver {
			commonFactors = getCommonFactors(name.length)
			return this
		}
		
		fun Shipment.getStreetName(): Shipment {
			streetName = address.split(" ", ignoreCase = true, limit = 2)[1]
			return this
		}
		
		fun Shipment.getCommonFactors(): Shipment {
			commonFactors = streetName?.let {
				getCommonFactors(it.length)
			} ?: mutableListOf()
			
			return this
		}
		
		fun getCommonFactors(number: Int): List<Int> {
			
			val returnList = mutableListOf<Int>()
			
			for (i in 2..number) {
				val factor = number % i
				if (factor == 0) {
					returnList.add(i)
				}
			}
			
			return returnList
		}
		
		fun loadingAnim(): RotateAnimation {
			val anim = RotateAnimation(
				360.0f,
				0.0f,
				Animation.RELATIVE_TO_SELF,
				0.5f,
				Animation.RELATIVE_TO_SELF,
				0.5f
			)
			
			anim.interpolator = LinearInterpolator()
			anim.repeatCount = Animation.INFINITE
			anim.duration = 500
			
			return anim
		}
	}
}