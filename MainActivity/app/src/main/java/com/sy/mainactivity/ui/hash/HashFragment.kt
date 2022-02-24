package com.sy.mainactivity.ui.hash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sy.mainactivity.databinding.FragmentHashBinding

class HashFragment : Fragment() {
    private var mBinding: FragmentHashBinding? = null
    private val binding get() = mBinding!!
    private var viewPager: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager = binding.viewpagerVP
        tabLayout = binding.tabLayoutTL

        val pagerAdapter = HashPagerAdapter(requireActivity())
        pagerAdapter.addFragment(HashGeneratorFragment(), "AAA")
        pagerAdapter.addFragment(HashVerifyFragment(), "BBB")

        viewPager!!.adapter = pagerAdapter

        TabLayoutMediator(tabLayout!!, viewPager!!) {tab, position->
            if (position == 0)
                tab.text = "Generate"
            else
                tab.text = "Verify"
        }.attach()
    }
}