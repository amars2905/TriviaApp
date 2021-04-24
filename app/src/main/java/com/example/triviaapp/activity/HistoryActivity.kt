package com.example.triviaapp.activity

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triviaapp.R
import com.example.triviaapp.adapter.HistoryAdapter
import com.example.triviaapp.room.UserDataBase
import com.example.triviaapp.room.UserInfo
import kotlinx.android.synthetic.main.activity_history.*

public class HistoryActivity : AppCompatActivity() {
    private var userDataBase: UserDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        userDataBase = UserDataBase.getDatabase(this)

        GetDataFromDb(this).execute();

    }

    private class GetDataFromDb(var context: HistoryActivity) : AsyncTask<Void, Void, List<UserInfo>>() {
        lateinit var list: ArrayList<UserInfo>
        override fun doInBackground(vararg params: Void?): List<UserInfo> {
            return context.userDataBase!!.userInfoDao().getAll()
        }
        override fun onPostExecute(userInfoList: List<UserInfo>?) {
            list = ArrayList()
            if (userInfoList!!.size > 0) {
                for (i in 0..userInfoList.size - 1) {
                    Log.e("Data", userInfoList[i].name)
                    list.add(UserInfo(userInfoList[i].name,userInfoList[i].qus1,userInfoList[i].qus2,userInfoList[i].date))
                }
                context.setAdapter(list)
            }
        }
    }

    public fun setAdapter(list: ArrayList<UserInfo>){
        historyactivity_list.layoutManager = LinearLayoutManager(this)
        historyactivity_list.itemAnimator = DefaultItemAnimator()
        historyactivity_list.adapter = HistoryAdapter(this, list)
    }

}



