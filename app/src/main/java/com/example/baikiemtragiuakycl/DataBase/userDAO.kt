package com.example.baikiemtragiuakycl.DataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.baikiemtragiuakycl.model.UserModel
@Dao
interface UserDao {
    @Insert
    fun insert(user: UserModel)
}
