package com.example.triviaapp.activity

import android.content.Intent
import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.triviaapp.R
import com.example.triviaapp.room.UserDataBase
import com.example.triviaapp.room.UserInfo
import com.example.triviaapp.util.AppPreference
import com.example.triviaapp.util.Constant
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.activity_user_name.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class SummaryActivity : AppCompatActivity() {

    private var userDataBase: UserDataBase? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        userDataBase = UserDataBase.getDatabase(this)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formatted = current.format(formatter)
        println("Current Date is: $formatted")

        summaryactivity_username.text = "Hello "+AppPreference.getStringPreference(this, Constant.strUserName)
        summaryactivity_first_answer.text = "Answer : "+AppPreference.getStringPreference(this, Constant.strQus1)
        summaryactivity_secound_answer.text = "Answer : "+AppPreference.getStringPreference(this, Constant.strQus2)

        val userInfo = UserInfo(""+AppPreference.getStringPreference(this, Constant.strUserName),""+AppPreference.getStringPreference(this, Constant.strQus1),""+AppPreference.getStringPreference(this, Constant.strQus2),formatted.toString())
        InsertTask(this,userInfo).execute()

        summaryactivity_finish.setOnClickListener { v -> newGame() }

        summaryactivity_history.setOnClickListener { v ->
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun newGame(){

        AppPreference.clearAllPreferences(this)
        val intent = Intent(this, UserNameActivity::class.java)
        startActivity(intent)
        finish()
    }

    private class InsertTask(var context: SummaryActivity, var userInfo: UserInfo) : AsyncTask<Void, Void, Boolean>() {
        override fun doInBackground(vararg params: Void?): Boolean {
            context.userDataBase!!.userInfoDao().insertAll(userInfo)
            return true
        }
        override fun onPostExecute(bool: Boolean?) {
            if (bool!!) {
                Toast.makeText(context, "Added to Database", Toast.LENGTH_LONG).show()
            }
        }
    }

}