package com.kamrulhasan.navigationcomponentdemo2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.kamrulhasan.navigationcomponentdemo2.R
import com.kamrulhasan.navigationcomponentdemo2.Trainee
import kotlinx.android.synthetic.main.fragment_about.*

class AboutFragment : Fragment() {

    val get_args: AboutFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val traineeId = "Trainee Id: ${get_args.id}"
        tv_arg_show.text = traineeId

        btn_home.setOnClickListener {
            val action = AboutFragmentDirections.actionAboutFragmentToHomeFragment()
            findNavController().navigate(action)
        }

        btn_profile.setOnClickListener {
            val trainee = Trainee("First", "Last", get_args.id)
            val action = AboutFragmentDirections.actionAboutFragmentToProfileFragment(trainee)
            findNavController().navigate(action)
        }
    }
}