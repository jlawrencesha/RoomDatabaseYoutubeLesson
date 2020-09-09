package com.giftofhappiness.roomdatabaseyoutubelesson.fragements.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.giftofhappiness.roomdatabaseyoutubelesson.R
import com.giftofhappiness.roomdatabaseyoutubelesson.data.Friends
import com.giftofhappiness.roomdatabaseyoutubelesson.data.User
import com.giftofhappiness.roomdatabaseyoutubelesson.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.coroutines.InternalCoroutinesApi


class AddFragment : Fragment() {

    @InternalCoroutinesApi
    private lateinit var mUserViewModel: UserViewModel
    @InternalCoroutinesApi
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)


        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.addButton.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    @InternalCoroutinesApi
    private fun insertDataToDatabase(){

        val firstName = firstNameTxtBox.text.toString()
        val lastName = lastNameTxtBox.text.toString()
        val age = ageTxtBox.text


        if(inputCheck(firstName,lastName,age)){

            val user = User(id=0,firstName,lastName, Integer.parseInt(age.toString()))
            val friend = Friends(friendId = 0,userCreatorId = 0,lastName)
            mUserViewModel.addUser(user)
            mUserViewModel.addFriend(friend)


            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }


    }

    private fun inputCheck(firstName: String, lastName: String, age:Editable ): Boolean{
        return!(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())



    }

}