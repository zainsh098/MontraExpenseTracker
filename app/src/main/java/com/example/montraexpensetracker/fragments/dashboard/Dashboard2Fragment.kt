package com.example.montraexpensetracker.fragments.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentDashboard2Binding


class Dashboard2Fragment : Fragment() {


    private lateinit var binding: FragmentDashboard2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDashboard2Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.componentDashboard.apply {
            dashImageView.setImageResource(R.drawable.illustration2)
            dashTitleTextView.text = getString(R.string.onboarding_screen_heading_2)
            dashboardSubtitle.text = getString(R.string.onboarding_screen_subtitle_2)

        }
    }

}