package com.sy.mainactivity.ui.hash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.sy.mainactivity.R
import com.sy.mainactivity.databinding.FragmentHashGenerateBinding
import com.sy.mainactivity.module.Crypto
import android.widget.ArrayAdapter as ArrayAdapter

class HashGeneratorFragment : Fragment() {
    private var mBinding: FragmentHashGenerateBinding? = null
    private val binding get() = mBinding!!
    private var spinnerHashAlgo: Spinner? = null
    private var editTextPT: EditText? = null
    private var editTextCT: TextInputEditText? = null
    private var buttonGenerate: Button? = null


    private var selectedHashAlgorithm: String = ""
    var dataArr = arrayOf("MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHashGenerateBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        editTextPT = binding.editTextPlainText
        editTextCT = binding.editTextCipherText
        buttonGenerate = binding.buttonGenerate

        val adapter = ArrayAdapter(binding.root.context, R.layout.list_item, dataArr)
        (binding.autoCompleteTextViewComboItem as? AutoCompleteTextView)?.setAdapter(adapter)
        (binding.autoCompleteTextViewComboItem as? AutoCompleteTextView)?.onItemClickListener =
            object : AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
                override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedHashAlgorithm = dataArr[p2]
                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    TODO("Not yet implemented")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        buttonGenerate!!.setOnClickListener(View.OnClickListener {
            var plaintext: String = editTextPT!!.text.toString()
            var cryptoModule = Crypto()
            var hash: ByteArray = cryptoModule.getHash(selectedHashAlgorithm, plaintext)
            fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }
            editTextCT!!.setText(hash.toHex())
        })
    }
}