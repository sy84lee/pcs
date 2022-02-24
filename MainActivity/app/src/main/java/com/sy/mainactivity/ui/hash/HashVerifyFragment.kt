package com.sy.mainactivity.ui.hash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.sy.mainactivity.databinding.FragmentHashVerifyBinding
import com.sy.mainactivity.module.Crypto

class HashVerifyFragment : Fragment() {
    private var mBinding: FragmentHashVerifyBinding? = null
    private val binding get() = mBinding!!
    private var spinnerHashAlgo: Spinner? = null
    private var editTextPT: EditText? = null
    private var editTextCT: EditText? = null
    private var buttonVerify: Button? = null

    private var selectedHashAlgorithm: String = ""
    var dataArr = arrayOf("MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHashVerifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        spinnerHashAlgo = binding.spinnerHashAlgo
        editTextPT = binding.editTextPlainText
        editTextCT = binding.editTextCipherText
        buttonVerify = binding.buttonVerify

        val adapter = ArrayAdapter(binding.root.context, android.R.layout.simple_spinner_item, dataArr)
        spinnerHashAlgo!!.adapter = adapter
        spinnerHashAlgo!!.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedHashAlgorithm = dataArr[p2]
                }
            }

        buttonVerify!!.setOnClickListener(View.OnClickListener {
            var plaintext = editTextPT!!.text.toString()
            var ciphertext = editTextCT!!.text.toString()

            var cryptoModule = Crypto()
            var hash = cryptoModule.getHash(selectedHashAlgorithm, plaintext)
            fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }

            var hashString = hash.toHex()
            if (hashString.equals(ciphertext))
                Toast.makeText(binding.root.context, "Success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(binding.root.context, "Fail", Toast.LENGTH_SHORT).show()
        })

    }
}