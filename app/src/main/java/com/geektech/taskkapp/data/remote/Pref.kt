package com.geektech.taskkapp.data.remote

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.media.Image

class Pref(private val context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences(TASK_PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean {
        return pref.getBoolean(USER_SEEN_KEY, false)
    }
    fun saveUserSeen(){
        pref.edit().putBoolean(USER_SEEN_KEY,true).apply()
    }

    fun saveImage(image: String) {

        pref.edit().putString(IMAGE_PROFILE, image).apply()
    }

    fun getImage(): String? {
        return pref.getString(IMAGE_PROFILE, "")
    }
    fun saveName(name: String) {
        pref.edit().putString(NAME_PROFILE, name).apply()
    }

    fun getName(): String? {
        return pref.getString(NAME_PROFILE, "")
    }

    companion object {
        const val TASK_PREF_NAME = "TaskPref"
        const val USER_SEEN_KEY = "user.seen"
        private const val IMAGE_PROFILE = "image.profile"
        private const val NAME_PROFILE = "pref.task"
    }
}