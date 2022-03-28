package com.sy.pcs.ui.text.aes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sy.pcs.databinding.FragmentAesBinding

class AesFragment : Fragment() {
    private var mBinding: FragmentAesBinding? = null
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
        mBinding = FragmentAesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewPager = binding.viewpagerVP
        tabLayout = binding.tabLayoutTL

        val pagerAdapter = AesPagerAdapter(requireActivity())
        pagerAdapter.addFragment(TextEncryptFragment(), "AAA")
        pagerAdapter.addFragment(TextDecryptFragment(), "BBB")

        viewPager!!.adapter = pagerAdapter

        TabLayoutMediator(tabLayout!!, viewPager!!) {tab, position->
            if (position == 0)
                tab.text = "Encrypt"
            else
                tab.text = "Decrypt"
        }.attach()
    }
}