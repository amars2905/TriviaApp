package com.example.triviaapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.triviaapp.R
import com.example.triviaapp.util.AppPreference
import com.example.triviaapp.util.Constant
import kotlinx.android.synthetic.main.activity_qus2.*

class QusActivity2 : AppCompatActivity() {
    val result = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qus2)

        qusactivity_two_next_button.setOnClickListener { v -> validation() }

    }

    fun validation(){
        if (qusactivity_white_checkbox.isChecked){
            result.append("White, ")
        }
        if (qusactivity_orange_checkbox.isChecked){
            result.append("Orange, ")
        }
        if (qusactivity_yellow_checkbox.isChecked){
            result.append("Yellow, ")
        }
        if (qusactivity_green_checkbox.isChecked){
            result.append("Green")
        }

        AppPreference.setStringPreference(this, Constant.strQus2, result.toString())

        val intent = Intent(this, SummaryActivity::class.java)
        startActivity(intent)
        finish()

    }

}