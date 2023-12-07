package com.example.myapplication.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.fragment.Home
import com.example.myapplication.fragment.Profile
import com.example.myapplication.fragment.Setting

internal class MyAdapter(var context: Context, fm: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                Home()
            }

            1 -> {
                Profile()
            }

            2 -> {
                Setting()
            }
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }

    override  fun getCount(): Int {
        return totalTabs
    }
}
