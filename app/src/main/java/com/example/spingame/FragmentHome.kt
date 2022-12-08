package com.example.spingame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.spingame.databinding.FragmentHomeBinding

class FragmentHome: Fragment(R.layout.fragment_home) {


    private lateinit var binding:FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        binding = FragmentHomeBinding.bind(view)


        binding.cardSpinandwin.setOnClickListener {
            navController.navigate(R.id.action_fragmentHome_to_fragment_spinwheel)
        }


        binding.cardScratchcard.setOnClickListener {
            navController.navigate(R.id.action_fragmentHome_to_fragmentScratchCard)
        }

        binding.cardQuiz.setOnClickListener {
            navController.navigate(R.id.action_fragmentHome_to_fragmentQuiz)
        }




    }



}