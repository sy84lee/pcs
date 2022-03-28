package com.sy.pcs.ui.text.aes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AesPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){

    var fragments : ArrayList<Fragment> = ArrayList()

    fun addFragment(fragment: Fragment, title: String){
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}