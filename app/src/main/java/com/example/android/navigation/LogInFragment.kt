
package com.example.android.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentLogInBinding>(
                inflater, R.layout.fragment_log_in, container, false)

        binding.logIn.setOnClickListener { view : View ->
            view.findNavController().navigate(LogInFragmentDirections.actionGameFragmentToClientPageFragment())
        }

        binding.signInButton.setOnClickListener{ view : View ->
            view.findNavController().navigate(LogInFragmentDirections.actionGameFragmentToGameOverFragment())
        }

        return binding.root
    }


}
