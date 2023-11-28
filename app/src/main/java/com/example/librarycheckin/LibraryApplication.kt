package com.example.librarycheckin

import android.app.Application
import com.example.librarycheckin.data.AppContainer
import com.example.librarycheckin.data.AppDataContainer

class LibraryApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}