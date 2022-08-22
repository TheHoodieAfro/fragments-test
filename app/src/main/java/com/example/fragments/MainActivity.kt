package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navBar : BottomNavigationView

    private lateinit var newItemFragment: NewTaskFragment
    private lateinit var itemListFragment: ItemListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newItemFragment = NewTaskFragment.newInstance()
        itemListFragment = ItemListFragment.newInstance()

        navBar = findViewById(R.id.navBar)

        showFragment(itemListFragment)

        navBar.setOnItemSelectedListener { menuItem ->
            if(menuItem.itemId == R.id.newItem) {
                showFragment(newItemFragment)
            }else if(menuItem.itemId == R.id.itemList) {
                showFragment(itemListFragment)
            }

            true
        }

    }

    fun showFragment(fragment : Fragment) {

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.fragmentLayout, fragment)
        transaction.commit()
    }

}