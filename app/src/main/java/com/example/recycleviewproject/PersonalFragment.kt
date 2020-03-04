package com.example.recycleviewproject


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.recycleviewproject.data.User
import com.example.recycleviewproject.databinding.FragmentPersonalBinding

/**
 * A simple [Fragment] subclass.
 */
class PersonalFragment : Fragment(), View.OnClickListener  {

    lateinit var mBinding: FragmentPersonalBinding
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_personal, container, false)
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.prevScreen).setOnClickListener(this)
        //mBinding = DataBindingUtil.setContentView(this.requireActivity(), R.layout.fragment_personal)
        mBinding.user = arguments!!.getParcelable("data")!!
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.prevScreen -> {
                navController!!.navigate(R.id.action_personalFragment_to_mainFragmentList)
            }
        }
    }


}
