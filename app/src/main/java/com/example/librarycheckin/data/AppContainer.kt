package com.example.librarycheckin.data

import android.content.Context
import androidx.room.Database

interface AppContainer {
    val usersRepository: UsersRepository
}

class AppDataContainer(private val context: Context): AppContainer{

    override val usersRepository: UsersRepository by lazy {
        OfflineUsersRepository(UsersDatabase.getDatabase(context).UserDAO())
    }
}
