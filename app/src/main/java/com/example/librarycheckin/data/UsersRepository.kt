package com.example.librarycheckin.data

import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    //retrieve all users from data source
    fun getAllUsersStream(): Flow<List<User>>

    //retrieve a user from a data source that matches with the [id]
    fun getUserStream(id: String): Flow<User?>

    /**
     * Insert user in the data source
     */

    suspend fun insertUser(user: User)

    /**
     * Delete item from the data source
     */
    suspend fun deleteUser(user: User)

    /**
     * Update item in the data source
     */
    suspend fun updateUser(user: User)
}