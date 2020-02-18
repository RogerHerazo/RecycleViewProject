package com.example.recycleviewproject

import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.data.User
import kotlinx.android.synthetic.main.row.view.*

class MyUserRecyclerViewAdapter(
    private val mValues: List<User>) : RecyclerView.Adapter<MyUserRecyclerViewAdapter.Viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: MyUserRecyclerViewAdapter.Viewholder, position: Int) {
        val item = mValues[position]
        holder.textView.text = item.nombre
    }

    inner class Viewholder(val mView: View) : RecyclerView.ViewHolder(mView){
        val button : Button = mView.buttonDeleteUser
        val textView: TextView = mView.textViewUserName
    }
}