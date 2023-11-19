package com.example.librarycheckin.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

//Hard-coded data
@Entity(tableName = "users")
data class User(
    val firstName: String,
    val lastName: String,
    @PrimaryKey(autoGenerate = false)
    val deviceId: String,
    val laptopMake: String,
    val identityNumber: Long,
    val date: LocalDateTime = LocalDateTime.now(),

    )

object UserData{
    var usersList = mutableListOf<User>(
        User(
            "Jokab",
            "Moryy",
            "drtg-345",
            "HP",
            979557563673753
        ),
        User(
            "Carrick",
            "Man",
            "dr65-345",
            "Lenovo",
            9796775563673753
        )
    )
    fun findUserById(identityNumber: Long?): User{
        return usersList.first{it.identityNumber == identityNumber}
    }
    fun findUserByName(firstName: String?){
        usersList.find{it.firstName == firstName}
    }
}
