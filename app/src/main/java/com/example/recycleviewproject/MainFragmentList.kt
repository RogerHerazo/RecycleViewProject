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
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.example.recycleviewproject.data.User
import kotlinx.android.synthetic.main.fragment_main_fragment_list.view.*
import org.json.JSONArray
import org.json.JSONObject
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


        adapter = MyUserRecyclerViewAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        view.floatingActionButton.setOnClickListener{


            VolleySingleton.getInstance(activity!!.applicationContext).addToRequestQueue(getJsonObjectRequest())
        }
        return view
    }

    fun getStringRequest() : StringRequest {
        val url = "https://randomuser.me/api?results=5"

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

    fun getJsonObjectRequest() : JsonObjectRequest {
        val url = "https://randomuser.me/api"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                parseObject (response)
                //parseObjectG (response)
            },
            Response.ErrorListener{
                Log.d("Error","error")
            }
        )

        return jsonObjectRequest
    }

    fun parseObject(response: JSONObject){
        val jsonArrayResults : JSONArray = response.getJSONArray("results")
        val size : Int = jsonArrayResults.length()
        val i : Int = 0
        for (i in 0..size -1){
            val userObject = jsonArrayResults.getJSONObject(i)
            //val gender = userObject.getString("gender")
            val nameObject = userObject.getJSONObject("name")
            val titulo  = nameObject.getString("title")
            val nombre = nameObject.getString("first")
            val apellido = nameObject.getString("last")
            val mail = userObject.getString("email")
            val phone = userObject.getString("phone")
            Log.d("JSONparsing",    titulo + " " + nombre + "  " + apellido + "  " + mail + "  " + phone)
            users.add(User(titulo,nombre, apellido, mail, phone))
            adapter!!.updateData()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

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
