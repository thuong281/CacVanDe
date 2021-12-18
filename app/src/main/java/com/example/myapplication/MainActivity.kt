package com.example.myapplication

import com.example.myapplication.R
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        initViewPager()
    }
    
    private fun initViewPager() {
        val adapter = PageAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        binding.pager.adapter = adapter
        binding.pager.setPagingEnabled(false)
        binding.pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
            }
    
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.tab.menu.findItem(R.id.lesson).isChecked  = true
                    }
                    1 -> {
                        binding.tab.menu.findItem(R.id.game).isChecked  = true
                    }
                    2 -> {
                        binding.tab.menu.findItem(R.id.painting).isChecked = true
                    }
                }
            }
    
            override fun onPageScrollStateChanged(state: Int) {
            }
    
        })
        binding.tab.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.lesson -> {
                    binding.pager.currentItem = 0
                }
                R.id.game -> {
                    binding.pager.currentItem = 1
                }
                R.id.painting -> {
                    binding.pager.currentItem = 2
                }
            }
            true
        }
    }
}