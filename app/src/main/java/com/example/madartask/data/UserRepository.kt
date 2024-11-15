package com.example.madartask.data

import androidx.lifecycle.LiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * Created by: Mahmoud Ibrahim on 11/15/2024
 * Email: mahmoudibrahiem57@gmail.com
 *
 **/
@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()

    suspend fun insertUser(user: User) = userDao.insertUser(user)
}
