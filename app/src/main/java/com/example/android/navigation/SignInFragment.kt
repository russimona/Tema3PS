package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentSignInBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_sign_in, container, false)

        binding.signinButton.setOnClickListener { view : View ->
            view.findNavController().navigate(SignInFragmentDirections.actionGameOverFragmentToLoginFragment())
        }

        return binding.root
    }
}
