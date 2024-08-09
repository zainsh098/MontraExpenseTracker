package com.example.montraexpensetracker.fragments.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.montraexpensetracker.fragments.dashboard.Dashboard1Fragment
import com.example.montraexpensetracker.fragments.dashboard.Dashboard2Fragment
import com.example.montraexpensetracker.fragments.dashboard.Dashboard3Fragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> Dashboard1Fragment()
            1 -> Dashboard2Fragment()
            2 -> Dashboard3Fragment()
            else -> throw IllegalStateException("Unexpected position $position")

        }
    }
}