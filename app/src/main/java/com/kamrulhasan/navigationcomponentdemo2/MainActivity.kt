package com.kamrulhasan.navigationcomponentdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.kamrulhasan.navigationcomponentdemo2.fragment.AboutFragment
import com.kamrulhasan.navigationcomponentdemo2.fragment.HomeFragment
import com.kamrulhasan.navigationcomponentdemo2.fragment.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btm_nv_menu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_item_about ->  {
                    changeLayout(AboutFragment())
                    true
                }
                R.id.menu_item_profile ->{
                    changeLayout(ProfileFragment())
                    true
                }
                else -> {
                    changeLayout(HomeFragment())
                    true
                }
            }
        }

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_view) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun changeLayout(fragment: Fragment){
        val fragmentNav = supportFragmentManager.beginTransaction()
        fragmentNav.replace(R.id.nav_host_view, fragment)
        fragmentNav.commit()
    }
}