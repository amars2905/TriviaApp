package com.example.triviaapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserInfoDao{
    @Insert
    fun insertAll(vararg userInfo: UserInfo)

    @Query("SELECT * FROM user_test")
    fun getAll(): List<UserInfo>

}