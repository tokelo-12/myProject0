package com.example.librarycheckin.user

import com.example.librarycheckin.data.User


/* Represents Ui State for a User.
*/
data class UserUiState(
    val userDetails: UserDetails =  UserDetails(),
    val isEntryValid: Boolean = false
)

//single user
data class UserDetails(
    val firstName: String = "",
    val lastName: String = "",
    val deviceId: String = "",
    val laptopMake: String = "",
    val identityNumber: Long = 0,
)


fun UserDetails.toUser(): User = User(
    firstName, lastName, deviceId, laptopMake, identityNumber
)