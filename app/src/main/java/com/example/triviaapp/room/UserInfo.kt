package com.example.triviaapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "user_test")
data class UserInfo(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "qus1") var qus1: String,
    @ColumnInfo(name = "qus2") var qus2: String,
    @ColumnInfo(name = "date") var date: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)