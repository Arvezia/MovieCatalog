package com.naufaldy.moviecatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naufaldy.moviecatalog.adapter.SectionPagerAdapter
import com.naufaldy.moviecatalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)


    }
}