package com.example.vascomm.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.vascomm.R
import com.example.vascomm.databinding.ActivityMainBinding
import com.example.vascomm.databinding.DrawerHeaderLayoutBinding
import com.example.vascomm.databinding.ToolbarBinding
import com.example.vascomm.view.home.HomeFragment
import com.example.vascomm.view.profile.ProfileFragment
import com.example.vascomm.view.search.SearchFragment
import com.google.android.material.card.MaterialCardView
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding: ToolbarBinding
    private lateinit var drawerLayoutBinding: DrawerHeaderLayoutBinding

    private lateinit var toolbarDrawer: Toolbar

    private lateinit var cardViewSearch: MaterialCardView
    private lateinit var navigationView: NavigationView
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        toolbarBinding = binding.toolbarLayout
        drawerLayoutBinding = binding.mainLayout
        setContentView(binding.root)


        initNavigationMenu()

        if (savedInstanceState == null) {
            val currentFragment: Fragment = HomeFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.content_main, currentFragment)
                .commit()
        }

        drawerLayoutBinding.home.setOnClickListener {
            lifecycleScope.launch {
                drawer.closeDrawers()
                delay(500)
                showHomeFragment()
            }
        }
        drawerLayoutBinding.search.setOnClickListener {
            lifecycleScope.launch {
                drawer.closeDrawers()
                delay(500)
                showSearchFragment()
            }
        }
        drawerLayoutBinding.profile.setOnClickListener {
            lifecycleScope.launch {
                drawer.closeDrawers()
                delay(500)
                showProfileFragment()
            }
        }
    }


    private fun initNavigationMenu() = binding.apply {
        setSupportActionBar(toolbarBinding.toolbar)

        drawer = findViewById(R.id.drawer_layout)

        navigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawer,
            toolbarBinding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun showSearchFragment() {
        val fragment = SearchFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.contentMain.id, fragment, "SearchFragment")
        fragmentTransaction.commit()
    }

    private fun showHomeFragment() {
        val fragment = HomeFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.contentMain.id, fragment, "HomeFragment")
        fragmentTransaction.commit()
    }

    private fun showProfileFragment() {
        val fragment = ProfileFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.contentMain.id, fragment, "ProfileFragment")
        fragmentTransaction.commit()
    }
}