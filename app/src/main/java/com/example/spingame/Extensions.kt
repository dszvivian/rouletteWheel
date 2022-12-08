package com.example.spingame

import android.app.Activity
import android.widget.Toast

fun Activity.toast(text:String){
    Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
}
