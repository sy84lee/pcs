package com.sy.pcs.ui.hash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.sy.pcs.R
import com.sy.pcs.databinding.FragmentHashVerifyBinding
import com.sy.pcs.module.Crypto

class HashVerifyFragment : Fragment() {
    private var mBinding: FragmentHashVerifyBinding? = null
    private val binding get() = mBinding!!
    private var spinnerHashAlgo: Spinner? = null
    private var editTextPT: EditText? = null
    private var editTextCT: TextInputEditText? = null
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

        editTextPT = binding.editTextPlainText
        editTextCT = binding.editTextCipherText
        buttonVerify = binding.buttonVerify

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

        buttonVerify!!.setOnClickListener(View.OnClickListener {
            var plaintext: String  = editTextPT!!.text.toString()
            var ciphertext: String  = editTextCT!!.text.toString()

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