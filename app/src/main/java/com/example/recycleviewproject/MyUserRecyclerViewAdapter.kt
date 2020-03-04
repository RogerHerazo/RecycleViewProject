package com.example.recycleviewproject

import android.service.autofill.TextValueSanitizer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewproject.data.User
import kotlinx.android.synthetic.main.fragment_row.view.*
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.row.view.textViewUserLastname
import kotlinx.android.synthetic.main.row.view.textViewUserName
import kotlinx.android.synthetic.main.row.view.textViewUserTitle

class MyUserRecyclerViewAdapter(
    private val mValues: List<User>,
    private val mListener : onListInteraction
    ) : RecyclerView.Adapter<MyUserRecyclerViewAdapter.Viewholder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_row, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: MyUserRecyclerViewAdapter.Viewholder, position: Int) {
        val item = mValues[position]
        holder.textView1.text = item.titulo
        holder.textView2.text = item.nombre
        holder.textView3.text = item.apellido
        holder.textView4.text = item.mail
        holder.textView5.text = item.phone

        holder.mView.setOnClickListener{
            mListener?.onListInteraction(item)
        }
    }

    public fun updateData(){
        notifyDataSetChanged()
    }

    inner class Viewholder(val mView: View) : RecyclerView.ViewHolder(mView){
        val textView1: TextView = mView.textViewUserTitle
        val textView2: TextView = mView.textViewUserName
        val textView3: TextView = mView.textViewUserLastname
        val textView4: TextView = mView.textViewUserEmail
        val textView5: TextView = mView.textViewUserPhone
    }

    interface onListInteraction{
        fun onListInteraction(item: User?)

    }
}