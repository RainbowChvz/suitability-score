package com.platformscience.suitabilityscore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.platformscience.suitabilityscore.databinding.ActivityMainBinding
import com.platformscience.suitabilityscore.domain.Utils

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	private lateinit var navController: NavController
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		
		Utils.setContext(applicationContext)
		
		val navHostFragment = supportFragmentManager
			.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
		navController = navHostFragment.navController
		
		setupActionBarWithNavController(navController)
	}
	
	override fun onSupportNavigateUp(): Boolean {
		return navController.navigateUp() || super.onSupportNavigateUp()
	}
}