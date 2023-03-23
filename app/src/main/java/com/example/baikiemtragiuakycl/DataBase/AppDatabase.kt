package com.example.baikiemtragiuakycl.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.baikiemtragiuakycl.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
