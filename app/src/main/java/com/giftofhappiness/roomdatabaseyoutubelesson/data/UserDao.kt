package com.giftofhappiness.roomdatabaseyoutubelesson.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFriend(friends: Friends)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Transaction
    @Query("SELECT * FROM user_table")
    fun getUserWithFriends():List<UserWithFriends>


}

