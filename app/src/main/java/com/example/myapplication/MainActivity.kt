package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    // Declare TabLayout and ViewPager here
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        // Initialize data for RecyclerView
        imageId = arrayOf(
            R.drawable.baso,
            R.drawable.mie,
            R.drawable.download,
            R.drawable.tempe,
            R.drawable.roti,
            R.drawable.buah,
            R.drawable.burger,
            R.drawable.ayam,
            R.drawable.semangka,
            R.drawable.nasikuning,
        )

        heading = arrayOf(
            "Mie Ayam pak vina",
            "Baso solo",
            "Nasi goreng",
            "Tempe bandung",
            "Nasi kuning",
            "Buah-buahan",
            "Burger king",
            "Makanan",
            "Ayam goreng",
            "Roti",
        )

        newArrayList = arrayListOf<News>()
        getUserdata()

        // Initialize TabLayout and ViewPager
        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewpager)

        // Initialize and set up the adapter
        val adapter = com.example.myapplication.adapter.MyAdapter(
            this,
            supportFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter

        // Add tabs to TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Profile"))
        tabLayout.addTab(tabLayout.newTab().setText("Setting"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // Set up the interaction between ViewPager and TabLayout
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun getUserdata() {
        // Populate data for RecyclerView
        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }

        // Set up the adapter for RecyclerView
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }
}
