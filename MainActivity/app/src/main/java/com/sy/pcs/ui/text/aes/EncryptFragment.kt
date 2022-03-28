package com.sy.pcs.ui.text.aes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sy.pcs.databinding.FragmentTextEncryptBinding

class TextEncryptFragment : Fragment() {
    private var mBinding: FragmentTextEncryptBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTextEncryptBinding.inflate(inflater, container, false)
        return binding.root
    }
}