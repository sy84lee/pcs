package com.sy.mainactivity.ui.hash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.sy.mainactivity.R
import com.sy.mainactivity.module.Crypto
import android.widget.ArrayAdapter as ArrayAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HashGeneratorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HashGeneratorFragment : Fragment() {

    private var selectedHashAlgorithm: String = ""

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var dataArr = arrayOf("MD5", "SHA-1", "SHA-224", "SHA-256", "SHA-384", "SHA-512")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_hash_generate, container, false)
        val adapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, dataArr)
        val spinner: Spinner = view.findViewById (R.id.hashalgo_spinner)
        spinner.adapter = adapter

        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    selectedHashAlgorithm = dataArr[p2]
                    //Toast.makeText(view.context, selectedHashAlgorithm, Toast.LENGTH_SHORT).show()
                }
            }

        val encryptButton: Button = view.findViewById(R.id.confirmButton)
        encryptButton.setOnClickListener(View.OnClickListener {
            var editText_pt: EditText = view.findViewById(R.id.plainText)
            var editText_ct: EditText = view.findViewById(R.id.cipherText)
            var plaintext: String = editText_pt.text.toString()
            var cryptoModule = Crypto()
            var hash: ByteArray = cryptoModule.getHash(selectedHashAlgorithm, plaintext)
            fun ByteArray.toHex() = joinToString(separator = "") { byte -> "%02x".format(byte) }
            editText_ct.setText(hash.toHex())
            //Toast.makeText(view.context, hash.toHex(), Toast.LENGTH_SHORT).show()
        })
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HashGenerateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HashGeneratorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}