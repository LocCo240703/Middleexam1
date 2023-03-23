package com.example.baikiemtragiuakycl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import com.example.baikiemtragiuakycl.DataBase.AppDatabase
import com.example.baikiemtragiuakycl.model.UserModel

@Suppress("UNREACHABLE_CODE")

class MainActivity : AppCompatActivity() {
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my-db"
        ).build()

        val btnSignUp = findViewById<Button>(R.id.signUp)
        btnSignUp.setOnClickListener{
            val Email= findViewById<TextView>(R.id.Email).text.toString()
            val User = findViewById<TextView>(R.id.User).text.toString()
            val Pass = findViewById<TextView>(R.id.Pass).text.toString()
            val Confirm = findViewById<TextView>(R.id.confrmPass).text.toString()
            if (Pass == Confirm) {
                val user = UserModel(
                    id = 0,
                    email = Email,
                    username =User,
                    password = Pass
                )
                Thread {
                    db.userDao().insert(user)
                }.start()
                Toast.makeText(
                    this@MainActivity,
                    "Register success!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Thông báo lỗi nếu password và confirm password không khớp
                Toast.makeText(
                    this@MainActivity,
                    "Password incorrect!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

