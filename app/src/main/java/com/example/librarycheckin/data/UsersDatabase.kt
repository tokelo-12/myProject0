package com.example.librarycheckin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// "entities = [User::class]" means Specify the User as the only class with the list of entities.
@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UsersDatabase: RoomDatabase() {

    abstract fun  UserDAO():  UserDAO

//allows access to the methods to create or get the database

    /**
     * The Instance variable keeps a reference to the database, when one has been created. This helps maintain a single instance of the database opened at a given time, which is an expensive resource to create and maintain
     */

    companion object {
        @Volatile
        private var instance: UsersDatabase? = null


        fun getDatabase(context: Context): UsersDatabase{
            return instance ?: synchronized(this){
                //get database
                Room.databaseBuilder(context, UsersDatabase::class.java, "user_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { instance = it } //keep reference to db

            }
        }
    }
}