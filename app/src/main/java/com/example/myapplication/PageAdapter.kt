package com.example.myapplication

import androidx.fragment.app.*
import com.example.myapplication.game.GameMenuFragment
import com.example.myapplication.lession.LessonFragment
import com.example.myapplication.painting.PaintingFragment
import com.example.myapplication.post.PostFragment
import com.example.myapplication.profile.ProfileFragment

class PageAdapter(fragment: FragmentManager, behavior: Int) : FragmentStatePagerAdapter(fragment, behavior) {
    override fun getCount() = 5
    
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LessonFragment()
            1 -> GameMenuFragment()
            2 -> PaintingFragment()
            3 -> PostFragment()
            4 -> ProfileFragment()
            else -> LessonFragment()
        }
    }
    
}