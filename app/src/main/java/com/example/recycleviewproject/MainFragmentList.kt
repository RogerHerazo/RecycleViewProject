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


        users.add(User("Mr","Brad","Gibson", "brad.gibson@example.com", "011-962-7516"))
        users.add(User("Ms","Margot", "Guillaume", "margot.guillaume@example.com", "06-64-02-54-93"))
        users.add(User("Mr", "Noah", "Brown", "noah.brown@example.com", "087-268-7339"))
        users.add(User("Mr", "Joel", "Jutila", "joel.jutila@example.com", "049-811-51-61"))
        users.add(User("Miss", "Fabiana", "Freitas", "fabiana.freitas@example.com", "(57) 9904-3198"))
        users.add(User("Mr", "Helge", "Brenna", "helge.brenna@example.com", "45464466"))
        users.add(User("Mr", "Eeli", "Salo","eeli.salo@example.com", "049-729-79-30"))
        users.add(User("Miss", "Signe", "Nielsen", "signe.nielsen@example.com", "19807694"))
        users.add(User("Mr", "Aaron", "Smith", "aaron.smith@example.com", "(684)-716-4481"))
        users.add(User("Mrs", "Madison", "Singh", "madison.singh@example.com", "335-336-3878"))
        users.add(User("Miss", "Josefine", "Hansen", "josefine.hansen@example.com", "33059620"))
        adapter = MyUserRecyclerViewAdapter(users)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter
        return view
    }


}
