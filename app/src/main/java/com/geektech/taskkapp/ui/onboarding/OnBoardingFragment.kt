package com.geektech.taskkapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.taskkapp.R
import com.geektech.taskkapp.data.remote.Pref
import com.geektech.taskkapp.databinding.FragmentOnboardingBinding
import com.geektech.taskkapp.databinding.FragmentTaskBinding
import com.geektech.taskkapp.model.OnBoard
import com.geektech.taskkapp.ui.onboarding.adapter.OnBoardingAdapter
import com.geektech.taskkapp.ui.task.utils.showToast


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var pref:Pref

    lateinit var vOnBoardingAdapter: OnBoardingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref=Pref(requireContext())
val adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter=adapter
        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)
    }
  private fun onClick(onBoard: OnBoard){
      findNavController().navigateUp()
      pref.saveUserSeen()


}

}

