package com.sy.mainactivity.ui.file

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sy.mainactivity.databinding.FragmentFileEncryptBinding
import java.io.File

class EncryptFragment : Fragment() {
    private var mBinding: FragmentFileEncryptBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFileEncryptBinding.inflate(inflater, container, false)
        binding.ButtonOpenFile.setOnClickListener(View.OnClickListener {
            val intent = Intent()
                .setType("*/*")
                .setAction(Intent.ACTION_GET_CONTENT)

            startActivityForResult(Intent.createChooser(intent, "Select a file"), 111)
            //Toast.makeText(binding.root.context, "Hello", Toast.LENGTH_SHORT).show()
        })

        return binding.root
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 111 && resultCode == RESULT_OK) {
            //val selectedFile = data?.dataString //The uri with the location of the file
            //binding.EditTextFilePath.setText(selectedFile.toString())

            val selectedFile = File(data?.data?.path)
            //val readData = FileInputStream(selectedFile).bufferedReader().use { it.readLine()
            //    binding.EditTextFilePath.setText(readData)
            //}
            //val readData = FileInputStream(selectedfile).bufferedReader().use { it.readText
            //    textView.text = readData
            //}

            binding.EditTextFilePath.setText(selectedFile.absoluteFile.toString())
            val uri = data?.data
            if (uri != null) {
                val inputStream = requireActivity().contentResolver.openInputStream(uri)
                //inputStream.re
            }
            //Toast.makeText(binding.root.context, selectedFile.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}