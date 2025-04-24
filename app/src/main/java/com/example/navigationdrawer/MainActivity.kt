package com.example.navigationdrawer
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.d("DRAWER", "MainAct - content view set")

        var toolb: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        Log.d("DRAWER", "MainAct - set toolb")
        if( toolb == null ) {
            Log.d("DRAWER", "MainAct -  toolb is null")
        }
        try {
            setSupportActionBar(toolb)
        } catch (ex: Exception) {
            Log.d("DRAWER", "MainAct - EXCEPTION")
            Log.d("DRAWER", "MainAct ${ex::class.simpleName} - ${ex.message}")


        }

        Log.d("DRAWER", "MainAct - support action bar set")



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        //Creating top level destinations
        //and adding them to the draw
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_recent, R.id.nav_favorites, R.id.nav_archive, R.id.nav_bin
            ), findViewById(R.id.drawer_layout)
        )

        //set up hamburger - to see drawer dropdown
        setupActionBarWithNavController(navController, appBarConfiguration)
        // set controller over Nav View
        findViewById<NavigationView>(R.id.nav_view) ?.setupWithNavController(navController)
        /*************************
        **************/
    }
    /******************/
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    /***********/
}