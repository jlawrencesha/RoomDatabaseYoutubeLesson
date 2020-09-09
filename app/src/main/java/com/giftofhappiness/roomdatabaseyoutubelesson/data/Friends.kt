package com.giftofhappiness.roomdatabaseyoutubelesson.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Friends(
    @PrimaryKey(autoGenerate = true)
    val friendId: Int,
    val userCreatorId: Int,
    val friendsNames : String)