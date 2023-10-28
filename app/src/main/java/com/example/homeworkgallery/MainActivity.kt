package com.example.homeworkgallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.homeworkgallery.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentList:  MutableList<Fragment> = mutableListOf()
        Photos.values().forEach {
            fragmentList.add(PhotoFragment(it))
        }
//        val fragmentList = listOf(
//            PhotoFragment(Photos.FOREST_PHONE),
//            PhotoFragment(Photos.MOUNTAINS),
//            PhotoFragment(Photos.SUNSET)
//        )
        val adapter = ViewPagerAdapter(supportFragmentManager , lifecycle, fragmentList)
        binding.viewPager.adapter = adapter
        binding.viewPager.setPageTransformer(ZoomTransformer())
        TabLayoutMediator(binding.tabLay, binding.viewPager){ tab , pos ->
            tab.text = getString(Photos.values()[pos].title)

        }.attach()
    }
}