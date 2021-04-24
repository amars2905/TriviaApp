package com.example.triviaapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.triviaapp.R
import com.example.triviaapp.util.AppPreference
import com.example.triviaapp.util.Constant
import kotlinx.android.synthetic.main.activity_qus1.*


class QusActivity1 : AppCompatActivity() {

    private lateinit var radioButton : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qus1)

        qusactivity_next_button.setOnClickListener { v ->  clickValue()}

    }

    fun clickValue(){
        val intSelectButton : Int = qusactivity_radiogroup!!.checkedRadioButtonId
        radioButton = findViewById(intSelectButton)
        AppPreference.setStringPreference(this, Constant.strQus1, radioButton.text.toString())

        val intent = Intent(this, QusActivity2::class.java)
        startActivity(intent)
        finish()

    }
}