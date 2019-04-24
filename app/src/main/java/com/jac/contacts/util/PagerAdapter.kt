package com.jac.contacts.util

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.jac.contacts.AboutFragment
import com.jac.contacts.ContactListFragment
import com.jac.contacts.R

class PagerAdapter(fm: FragmentManager, private val activity: Activity) : FragmentStatePagerAdapter(fm) {

    private val contactListFragment: ContactListFragment by lazy { ContactListFragment() }
    private val aboutFragment: AboutFragment by lazy { AboutFragment() }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> contactListFragment
            1 -> aboutFragment
            else -> contactListFragment
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> activity.getString(R.string.list)
            1 -> activity.getString(R.string.about)
            else -> activity.getString(R.string.list)
        }
    }
}