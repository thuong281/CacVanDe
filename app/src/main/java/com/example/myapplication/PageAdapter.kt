package com.example.myapplication

import androidx.fragment.app.*
import com.example.myapplication.game.GameMenuFragment
import com.example.myapplication.lession.LessonFragment
import com.example.myapplication.painting.PaintingFragment

class PageAdapter(fragment: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fragment, behavior) {
    override fun getCount() = 3
    
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LessonFragment()
            1 -> GameMenuFragment()
            2 -> PaintingFragment()
            else -> LessonFragment()
        }
    }
    
}