package com.sy.mainactivity.ui.text

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sy.mainactivity.R
import com.sy.mainactivity.databinding.FragmentHashGenerateBinding
import com.sy.mainactivity.databinding.FragmentTextBinding
import com.sy.mainactivity.ui.file.FileFragment
import com.sy.mainactivity.ui.text.aes.AesFragment

class TextFragment : Fragment() {
    private var mBinding: FragmentTextBinding? = null
    private val binding get() = mBinding!!

    private var buttonAES: Button? = null
    private var buttonRSA: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTextBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        buttonAES = binding.aesButton
        buttonRSA = binding.rsaButton

        val aesButtonContent = SpannableStringBuilder("AES\nBlock size : 64bit\nKey length : 128 bits, 192 bits, 256 bits")
        aesButtonContent.apply {
            setSpan(StyleSpan(Typeface.BOLD), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(Color.DKGRAY), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(1.2f), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(Color.GRAY), 4, 64, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(0.8f), 4, 64, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        buttonAES!!.text = aesButtonContent
        buttonAES!!.setOnClickListener(View.OnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, AesFragment()).commit()
        })

        val rsaButtonContent = SpannableStringBuilder("RSA\nKey length : 1024 bits, 2048 bits, 4096 bits")
        rsaButtonContent.apply {
            setSpan(StyleSpan(Typeface.BOLD), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(Color.DKGRAY), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(1.2f), 0, 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(Color.GRAY), 4, 48, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(RelativeSizeSpan(0.8f), 4, 48, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        buttonRSA!!.text = rsaButtonContent
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
