package com.example.montraexpensetracker.fragments.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentViewPagerBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adpater = ViewPagerAdapter(this)
        binding.viewPager2.adapter = adpater
        binding.indicator.setViewPager(binding.viewPager2)
        binding.buttonSignUp.setOnClickListener {

            findNavController().navigate(R.id.action_viewPagerFragment_to_signUpFragment)

        }

        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginFragment)

        }

    }
}