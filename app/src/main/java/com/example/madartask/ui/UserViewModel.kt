package com.example.madartask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.madartask.data.User
import com.example.madartask.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *
 * Created by: Mahmoud Ibrahim on 11/15/2024
 * Email: mahmoudibrahiem57@gmail.com
 *
 **/
@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val allUsers: LiveData<List<User>> = repository.getAllUsers()

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }
}
