package com.example.triviaapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserInfo::class), version = 3)
abstract class UserDataBase : RoomDatabase() {
    abstract fun userInfoDao() : UserInfoDao

    companion object {
        private var INSTANCE: UserDataBase? = null
        fun getDatabase(context: Context): UserDataBase? {
            if (INSTANCE == null) {
                synchronized(UserDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        UserDataBase::class.java, "user.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}