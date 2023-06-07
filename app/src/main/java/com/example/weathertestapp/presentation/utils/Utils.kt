package com.example.weathertestapp.presentation.utils

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.example.weathertestapp.R

const val COUNTRY_KAZ = "kazakhstan"
val navigationFragmentId = R.id.fragment_container_view


fun FragmentActivity.replaceFragment(
    fragment: Fragment,
    addToBackStack: Boolean = false,
    block: FragmentTransaction.() -> FragmentTransaction = { this }
): Fragment {
    val transaction = supportFragmentManager.beginTransaction()
    transaction
        .block()
        .replace(navigationFragmentId, fragment, fragment.javaClass.name)
        .apply {
            if (addToBackStack) this.addToBackStack(fragment.javaClass.name)
        }
        .commit()
    return fragment
}

fun View.visible(isVisible: Boolean, invisible: Int = View.GONE) {
    if (isVisible) this.visibility = View.VISIBLE
    else this.visibility = invisible
}