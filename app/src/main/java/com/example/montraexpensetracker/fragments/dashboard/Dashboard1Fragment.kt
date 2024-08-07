package com.example.montraexpensetracker.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentDashboard1Binding
import com.example.montraexpensetracker.databinding.FragmentDashboard2Binding

class Dashboard1Fragment : Fragment() {

    private lateinit var binding: FragmentDashboard1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboard1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.componentDashboard.apply {
            dashImageView.setImageResource(R.drawable.ilustration)
            dashTitleTextView.text = getString(R.string.onboarding_screen_heading_1)
            dashboardSubtitle.text = getString(R.string.onboarding_screen_subtitle_1)

        }
    }
}