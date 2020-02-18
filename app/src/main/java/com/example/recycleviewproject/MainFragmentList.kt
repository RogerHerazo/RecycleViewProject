package com.example.recycleviewproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleviewproject.data.User
import kotlinx.android.synthetic.main.fragment_main_fragment_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragmentList : Fragment() {

    val users = mutableListOf<User>()
    private var adapter: MyUserRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main_fragment_list, container, false)

        users.add(User("Roger"))
        users.add(User("Daniel"))
        adapter = MyUserRecyclerViewAdapter(users)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter
        return view
    }


}
