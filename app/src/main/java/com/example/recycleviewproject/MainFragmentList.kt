package com.example.recycleviewproject


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.recycleviewproject.data.User
import kotlinx.android.synthetic.main.fragment_main_fragment_list.view.*
import kotlin.math.PI

/**
 * A simple [Fragment] subclass.
 */
class MainFragmentList : Fragment(), View.OnClickListener, MyUserRecyclerViewAdapter.onListInteraction  {


    private lateinit var navController: NavController
    lateinit var Brad: User
    lateinit var Margot: User
    lateinit var Noah: User
    lateinit var Joel: User
    lateinit var Fabiana: User
    val users = mutableListOf<User>()
    private var adapter: MyUserRecyclerViewAdapter? = null
    var count : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main_fragment_list, container, false)


        users.add(User("Brad","Gibson"))
        users.add(User("Margot", "Guillaume"))
        users.add(User( "Noah", "Brown"))
        users.add(User( "Joel", "Jutila"))
        users.add(User( "Fabiana", "Freitas"))

        adapter = MyUserRecyclerViewAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener{
            users.add(User("Jhon"+count, "Doe"+count))
            count++
            adapter!!.updateData()

            VolleySingleton.getInstance(activity!!.applicationContext).addToRequestQueue(getStringRequest())
        }
        return view
    }

    fun getStringRequest() : StringRequest {
        val url = "http://www.google.com"

// Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                //textView.text = "Response is: ${response.substring(0, 500)}"
                Log.d("Response","Response is: ${response.substring(0, 500)}")
            },
            Response.ErrorListener {
                //textView.text = "That didn't work!"
                Log.d("Error","That didn't work!")})

        return stringRequest
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


        Brad = User("Brad","Gibson")
        Margot = User("Margot", "Guillaume")
        Noah = User( "Noah", "Brown")
        Joel = User( "Joel", "Jutila")
        Fabiana = User( "Fabiana", "Freitas")

    }

    override fun onClick(v: View?) {

    }

    override fun onListInteraction(item: User?) {
        //Log.d("KRecycle", "onListInteraction" + item!!.nombre)
        val bundle = bundleOf("data" to item)
        //val bundle = bundleOf("nombre" to item?.nombre)
        navController!!.navigate(R.id.action_mainFragmentList_to_personalFragment, bundle)
    }

}
