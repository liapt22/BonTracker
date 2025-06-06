package com.example.myapplicationtmppp.ui.notifications

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object NotificationStorage {
    private const val PREFS_NAME = "notifications_prefs"
    private const val NOTIFICATIONS_KEY = "notifications_list"

    fun saveNotification(context: Context, message: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        val notifications = getNotifications(context).toMutableList()
        notifications.add(message)

        val json = Gson().toJson(notifications)
        editor.putString(NOTIFICATIONS_KEY, json)
        editor.apply()
    }

    // NotificationStorage.kt
    fun getNotifications(context: Context): MutableList<String> {
        val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val json = sharedPreferences.getString(NOTIFICATIONS_KEY, "[]")
        val type = object : TypeToken<MutableList<String>>() {}.type
        return Gson().fromJson(json, type) ?: mutableListOf()
    }

    fun clearNotifications(context: Context) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().remove(NOTIFICATIONS_KEY).apply()
    }
}
