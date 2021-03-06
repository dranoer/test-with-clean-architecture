package com.dranoer.freshworks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dranoer.freshworks.databinding.ActivityMainBinding
import com.dranoer.freshworks.presentation.ui.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

val tabArray = arrayOf(
    "Main",
    "Fav",
)

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
    }
}