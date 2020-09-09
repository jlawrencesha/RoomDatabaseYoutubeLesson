package com.giftofhappiness.roomdatabaseyoutubelesson.data

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithFriends(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userCreatorId"
    )
    val friendsNames:List<Friends>

)

