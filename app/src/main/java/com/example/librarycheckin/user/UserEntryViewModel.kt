package com.example.librarycheckin.user

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.librarycheckin.data.OfflineUsersRepository
import com.example.librarycheckin.data.User
import com.example.librarycheckin.data.UsersRepository


class UserEntryViewModel(private var usersRepository: UsersRepository) : ViewModel() {

    /**
     * holds current ui state
     */

    var userUiState by mutableStateOf(UserUiState())
        private set

    private fun validateInput(uiState: UserDetails = userUiState.userDetails ): Boolean{
        return with(uiState){
            firstName.isNotBlank() && lastName.isNotBlank() && deviceId.isNotEmpty() && laptopMake.isNotBlank() && identityNumber.isNotBlank()
        }
    }
}

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
    val identityNumber: String = "",
)


fun UserDetails.toUser(): User = User(
    firstName, lastName, deviceId, laptopMake, identityNumber.toLong()
)

//Converts [User] to [UserUiState] for UI Consumption/usage
fun User.toUserUiState(isEntryValid: Boolean = false): UserUiState = UserUiState(
    userDetails = this.toUserDetails(),
    isEntryValid = isEntryValid
)

//Coming from the database. Converts [User] into [UserDetails]
fun User.toUserDetails(): UserDetails = UserDetails(
    firstName = firstName,
    lastName = lastName,
    deviceId = deviceId,
    laptopMake = laptopMake,
    identityNumber = identityNumber.toString()  //Converts to string from long
)