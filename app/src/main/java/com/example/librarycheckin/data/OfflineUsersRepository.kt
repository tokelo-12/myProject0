package com.example.librarycheckin.data

import kotlinx.coroutines.flow.Flow

class OfflineUsersRepository(private val userDAO: UserDAO): UsersRepository{


    override fun getAllUsersStream(): Flow<List<User>> = userDAO.getAllUsers()

    override fun getUserStream(id: String): Flow<User?> = userDAO.getUser(id)


    override suspend fun insertUser(user: User) = userDAO.insert(user)


    override suspend fun updateUser(user: User) = userDAO.update(user)

    override suspend fun deleteUser(user: User) = userDAO.delete(user)


}