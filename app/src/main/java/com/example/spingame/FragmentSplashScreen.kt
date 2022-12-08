package com.example.spingame

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.spingame.databinding.FragmentSplashscreenBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class FragmentSplashScreen: Fragment(R.layout.fragment_splashscreen) {

    private lateinit var binding:FragmentSplashscreenBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser


        binding = FragmentSplashscreenBinding.bind(view)

        val navController = Navigation.findNavController(view)

        val rotate: RotateAnimation = RotateAnimation(
            0f, (3600*5).toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotate.interpolator = DecelerateInterpolator()
        rotate.repeatCount = 0
        rotate.duration = 4000
        rotate.fillAfter = true
        binding.imageView.startAnimation(rotate)


        Handler().postDelayed({

            if(user != null){
                navController.navigate(R.id.action_fragmentSplashScreen_to_fragmentHome)
            }else{
                navController.navigate(R.id.action_fragmentSplashScreen_to_fragmentSignIn)
            }



        },3000)






    }


}


