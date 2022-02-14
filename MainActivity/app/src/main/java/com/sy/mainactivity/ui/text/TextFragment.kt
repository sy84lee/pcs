package com.sy.mainactivity.ui.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.sy.mainactivity.R
import com.sy.mainactivity.ui.file.FileFragment
import com.sy.mainactivity.ui.text.aes.AesFragment

class TextFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_text, container, false)
        val encryptButton: Button = view.findViewById(R.id.aesButton)
        encryptButton.setOnClickListener(View.OnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, AesFragment()).commit()
        })

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}