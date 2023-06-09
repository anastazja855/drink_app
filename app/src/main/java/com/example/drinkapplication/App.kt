package com.example.drinkapplication

import android.app.Application
import com.example.drinkapplication.db.MyFavoriteDrinkDB
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        MyFavoriteDrinkDB.init(applicationContext)
    }
}