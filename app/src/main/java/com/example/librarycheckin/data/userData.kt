package com.example.librarycheckin.data

import java.time.LocalDateTime

//Hard-coded data
class User(
    val firstName: String,
    val lastName: String,
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
        )
    )
    fun findUserById(identityNumber: Long?): User{
        return usersList.first{it.identityNumber == identityNumber}
    }
    fun findUserByName(firstName: String?){
        usersList.find{it.firstName == firstName}
    }
}
