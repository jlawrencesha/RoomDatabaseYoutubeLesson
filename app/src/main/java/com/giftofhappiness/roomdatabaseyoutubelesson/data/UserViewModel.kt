package com.giftofhappiness.roomdatabaseyoutubelesson.data


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch


@InternalCoroutinesApi
class UserViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository
    private val friendRepository: UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        friendRepository=UserRepository(userDao)
        readAllData = repository.readAllData
    }
        fun addUser(user: User){
            viewModelScope.launch(Dispatchers.IO){ this
            repository.addUser(user)
            }
        }

    fun addFriend(friends: Friends){
        viewModelScope.launch(Dispatchers.IO){ this
            friendRepository.addFriend(friends)
        }
    }


}