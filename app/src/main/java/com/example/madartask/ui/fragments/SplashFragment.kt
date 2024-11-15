package com.example.madartask.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.madartask.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Splash visible only 3 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(
                R.id.action_splashFragment_to_addNewUserFragment, null,
                NavOptions.Builder()
                    .setPopUpTo(R.id.splashFragment, true).build()
            )
        }, 3000)

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}