package com.example.triviaapp.util

import android.content.Context

object AppPreference {
    const val APP_PREFENCE = "TriviaApp_preference"

    fun setStringPreference(
        context: Context,
        key: String?,
        value: String?
    ) {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getStringPreference(context: Context, key: String?): String? {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        return preferences.getString(key, "")
    }

    fun setIntegerPreference(
        context: Context,
        key: String?,
        value: Int
    ) {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getIntegerPreference(context: Context, key: String?): Int {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        return preferences.getInt(key, 0)
    }

    fun setFloatPreference(
        context: Context,
        key: String?,
        value: Float
    ) {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getFloatPreference(context: Context, key: String?): Float {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        return preferences.getFloat(key, 0f)
    }

    fun setBooleanPreference(
        context: Context,
        key: String?,
        value: Boolean
    ) {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBooleanPreference(
        context: Context,
        key: String?
    ): Boolean {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        return preferences.getBoolean(key, false)
    }

    fun clearAllPreferences(context: Context) {
        val preferences = context.getSharedPreferences(
            APP_PREFENCE,
            Context.MODE_PRIVATE
        )
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}