package com.example.madartask.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 *
 * Created by: Mahmoud Ibrahim on 11/15/2024
 * Email: mahmoudibrahiem57@gmail.com
 *
 **/
@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllUsers(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

}

