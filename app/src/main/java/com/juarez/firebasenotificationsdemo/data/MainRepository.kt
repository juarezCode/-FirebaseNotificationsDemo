package com.juarez.firebasenotificationsdemo.data

import javax.inject.Inject

class MainRepository @Inject constructor(private val preferences: PreferencesManager) {

    suspend fun saveAge(key: String, value: String) {
        preferences.put(key, value)
    }

    suspend fun getAge(key: String): String? {
        return preferences.getString(key)
    }
}