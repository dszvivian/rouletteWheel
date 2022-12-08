package com.example.spingame

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.spingame.databinding.FragmentQuizBinding

class FragmentQuiz: Fragment(R.layout.fragment_quiz) {

    private lateinit var binding:FragmentQuizBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentQuizBinding.bind(view)

        binding.btnCheckAnswer.setOnClickListener {

            val ans = binding.etQuizAnswer.text.toString()

            if (ans.equals("77")){
                requireActivity().toast("Whooaaaa  You've  Got that ")
                binding.etQuizAnswer.setBackgroundColor(Color.GREEN)
            }
            else if(ans.equals("")){
                requireActivity().toast("Please Enter")
            }
            else{
                requireActivity().toast("Try again...")
                binding.etQuizAnswer.setBackgroundColor(Color.RED)
            }
        }


    }




}