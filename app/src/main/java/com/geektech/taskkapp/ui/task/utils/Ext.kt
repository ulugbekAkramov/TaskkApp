package com.geektech.taskkapp.ui.task.utils

import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Fragment.showToast(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
}
fun ImageView.loadImage(url:String?){
    Glide.with(this).load(url).into(this)

}