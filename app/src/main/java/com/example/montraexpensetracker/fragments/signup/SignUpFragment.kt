package com.example.montraexpensetracker.fragments.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.montraexpensetracker.R
import com.example.montraexpensetracker.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {


    private  lateinit var  binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSignUpBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            componentToolbar.textToolbar.text=getString(R.string.text_toolbar_signup)

        }
    }



}