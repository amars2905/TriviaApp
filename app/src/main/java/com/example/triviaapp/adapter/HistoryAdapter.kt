package com.example.triviaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triviaapp.R
import com.example.triviaapp.room.UserInfo

class HistoryAdapter(var ctx: Context, var list: ArrayList<UserInfo>) :
    RecyclerView.Adapter<HistoryAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(userInfo: UserInfo, ctx: Context, pos: Int) {
            var historyName = itemView.findViewById<TextView>(R.id.row_history_name)
            var historyDate = itemView.findViewById<TextView>(R.id.row_history_date)
            var historyQus1 = itemView.findViewById<TextView>(R.id.row_history_first_qus)
            var historyQus2 = itemView.findViewById<TextView>(R.id.row_history_secound_qus)

            historyDate.text = "GAME "+pos+1+" : "+userInfo.date
            historyName.text = "NAME : "+userInfo.name
            historyQus1.text = "Answer : "+userInfo.qus1
            historyQus2.text = "Answer : "+userInfo.qus2


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_history, parent, false))

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HistoryAdapter.MyViewHolder, position: Int) {
        holder.bindView(list[position],ctx,position)
    }
}