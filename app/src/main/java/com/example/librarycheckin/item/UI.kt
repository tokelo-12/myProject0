package com.example.librarycheckin.item

import com.example.librarycheckin.data.UserData

data class UiState(
    val checkInsCnt: Int = UserData.usersList.size,
    val checkInsTotal: Int = UserData.usersList.size,
)
