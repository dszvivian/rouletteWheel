package com.example.spingame

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.spingame.databinding.FragmentSpinwheelBinding
import kotlin.random.Random

class Fragment_spinwheel: Fragment(R.layout.fragment_spinwheel),Animation.AnimationListener {

    private lateinit var binding : FragmentSpinwheelBinding

    val prizes = arrayOf("MacBook","IPhone","1 Cr Cash","Honda CBR","200cash")
    private var mSpinDuration:Long = 3600
    private var mSpinRevolution = 5000f
    private var prizeText = "N/A"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding = FragmentSpinwheelBinding.bind(view)

        val wheel = binding.ivWheel
        val btnStart = binding.start



        //17 sections in our wheel

        // 360/17 = 21.176470588235294117647058823529

        // So if 18 degree --> 18/21.176470588235294117647058823529 =    ~= 0

        btnStart.setOnClickListener {


//            val end = Math.floor(Math.random() * 3600).toFloat()
//            val numOfPrizes = prizes.size
//            val degreePerPrize = 360/numOfPrizes
//            val shift = 0
//            val prizeIndex = (shift + end) % numOfPrizes

            val numOfPrizes = prizes.size
            val degreePerPrize = 360/numOfPrizes
            val endDegree = Math.floor(Math.random() * 360)
            val endIndex = Math.floor(endDegree / degreePerPrize)



            prizeText = "You have Won ${prizes[endIndex.toInt()]}"

            val degree = Math.random()
            val rotate: RotateAnimation = RotateAnimation(
                0f, (mSpinRevolution + endDegree).toFloat(),
                Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f
            )

            rotate.interpolator = DecelerateInterpolator()
            rotate.repeatCount = 0
            rotate.duration = 4000
            rotate.setAnimationListener(this)
            rotate.fillAfter = true
            wheel.startAnimation(rotate)

        }


    }




    override fun onAnimationStart(animation: Animation?) {
        binding.tvInfoText.text = "Spinning..."
    }

    override fun onAnimationEnd(animation: Animation?) {
        binding.tvInfoText.text = prizeText
    }

    override fun onAnimationRepeat(animation: Animation?) {
        TODO("Not yet implemented")
    }

}