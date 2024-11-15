package com.example.madartask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * Created by: Mahmoud Ibrahim on 11/15/2024
 * Email: mahmoudibrahiem57@gmail.com
 *
 **/
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)