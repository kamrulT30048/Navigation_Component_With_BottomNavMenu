package com.kamrulhasan.navigationcomponentdemo2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kamrulhasan.navigationcomponentdemo2.R
import com.kamrulhasan.navigationcomponentdemo2.Trainee
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_about.setOnClickListener {
            var id = 3000
            val input = tiet_id.text.toString()
            if(input.isNotEmpty()){
                id = input.toInt()
            }

            val action = HomeFragmentDirections.actionHomeFragmentToAboutFragment( id )
            findNavController().navigate(action)
        }

        btn_profile.setOnClickListener {

            val fName = if(tiet_fname.text.toString().isEmpty()){ "First"}else{ tiet_fname.text.toString() }
            val lName = if(tiet_lname.text.toString().isEmpty()){ "Last"}else{ tiet_lname.text.toString() }
            val id = if(tiet_id.text.toString().isEmpty()){ 30000 }else{ tiet_id.text.toString().toInt() }

            val trainee = Trainee(fName, lName, id)

            val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment(trainee)
            findNavController().navigate(action)
        }

    }
}