package com.geektech.taskkapp.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.geektech.taskkapp.R
import com.geektech.taskkapp.data.remote.Pref
import com.geektech.taskkapp.databinding.FragmentProfileBinding
import com.geektech.taskkapp.ui.task.utils.loadImage
import de.hdodenhof.circleimageview.CircleImageView

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    private var galleryActivityLauncher: ActivityResultLauncher<Array<String>> =
        registerForActivityResult(
            ActivityResultContracts.OpenDocument()
        ) { result ->
            if (result != null) {
                binding.profileImage.loadImage(result.toString())
                pref.saveImage(result.toString())
            } else {
                Log.d("lol", "onActivityResult: the result is null for some reason")
            }

        }

    lateinit var pref: Pref
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.profileImage.setOnClickListener {
            galleryActivityLauncher.launch(arrayOf("image/*"))


        }
        binding.profileImage.loadImage(pref.getImage())
        binding.etUserName.setText(pref.getName())
        binding.etUserName.addTextChangedListener { pref.saveName(binding.etUserName.text.toString()) }
    }

}