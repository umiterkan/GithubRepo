package com.erkan.githubrepo.ui

import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.erkan.githubrepo.R
import com.erkan.githubrepo.databinding.ActivityMainBinding
import com.erkan.githubrepo.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override val layoutIdRes: Int get() = R.layout.activity_main

    override fun init() {
        navController=findNavController(R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(binding.toolbar, navController)
        binding.floatingNightMode.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

    }

}
