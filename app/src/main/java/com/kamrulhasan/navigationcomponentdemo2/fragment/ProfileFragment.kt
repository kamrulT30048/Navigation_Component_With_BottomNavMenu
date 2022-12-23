package com.kamrulhasan.navigationcomponentdemo2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kamrulhasan.navigationcomponentdemo2.R
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    val get_args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // assigning Trainee object values
        val traineeProfile = "Trainee Info:\n" +
                "Id: ${get_args.trainee.id}\n " +
                "Name: ${get_args.trainee.firstName} ${get_args.trainee.lastName}"
        tv_arg_show.text = traineeProfile

        btn_about.setOnClickListener {
            val traineeId = get_args.trainee.id
            val action = ProfileFragmentDirections.actionProfileFragmentToAboutFragment(traineeId)
            findNavController().navigate(action)
        }

        btn_home.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
            findNavController().navigate(action)
        }
    }

}