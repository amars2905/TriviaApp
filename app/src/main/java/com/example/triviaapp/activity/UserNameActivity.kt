package com.example.triviaapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triviaapp.R
import com.example.triviaapp.util.AppPreference
import com.example.triviaapp.util.Constant
import kotlinx.android.synthetic.main.activity_user_name.*

class UserNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_name)

        username_activity_next_button.setOnClickListener { v -> validation()  }
    }

    private fun validation(){
        if (username_activity_name_edittext.text!!.isEmpty()){
            error()
        }else{
            AppPreference.setStringPreference(this,Constant.strUserName, username_activity_name_edittext.text!!.toString())
            val intent = Intent(this, QusActivity1::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun error(){
        username_activity_name_layout.error = "Enter user name"
    }
}