package com.example.spingame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.anupkumarpanwar.scratchview.ScratchView
import com.example.spingame.databinding.FragmentScratchcardBinding

class FragmentScratchCard : Fragment(R.layout.fragment_scratchcard) {

    private lateinit var binding: FragmentScratchcardBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentScratchcardBinding.bind(view)

        binding.scratchView.setRevealListener(object:ScratchView.IRevealListener{
            override fun onRevealed(scratchView: ScratchView?) {
                requireActivity().toast("You Won a Star")
                binding.scratchView.visibility = View.GONE
            }

            override fun onRevealPercentChangedListener(scratchView: ScratchView?, percent: Float) {
                if (percent>=0.5) {
                   scratchView?.reveal()
                }
            }

        })

    }



}