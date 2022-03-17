package com.sy.mainactivity.ui.text.aes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.sy.mainactivity.R
import com.sy.mainactivity.databinding.FragmentAesBinding
import com.sy.mainactivity.databinding.FragmentTextEncryptBinding

class TextEncryptFragment : Fragment() {
    private var mBinding: FragmentTextEncryptBinding? = null
    private val binding get() = mBinding!!
    private var viewPager: ViewPager2? = null
    private var tabLayout: TabLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("SY", "onCreateView-FirstFragment")
        return inflater.inflate(R.layout.fragment_text_encrypt, container, false)
    }
}
