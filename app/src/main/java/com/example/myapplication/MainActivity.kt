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
    
    private val tabTitles = listOf("Họa tiết", "Trò chơi")
    private val tabIcons = listOf(R.drawable.ic_baseline_menu_book_24, R.drawable.ic_baseline_videogame_asset_24)
    
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
                }
            }
    
            override fun onPageScrollStateChanged(state: Int) {
            }
    
        })
        binding.tab.setOnNavigationItemSelectedListener (object: BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.lesson -> {
                        binding.pager.currentItem = 0
                    }
                    R.id.game -> {
                        binding.pager.currentItem = 1
                    }
                }
                return true
            }
    
        })
    }
}