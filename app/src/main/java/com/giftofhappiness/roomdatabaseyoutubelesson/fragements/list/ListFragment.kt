package com.giftofhappiness.roomdatabaseyoutubelesson.fragements.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.giftofhappiness.roomdatabaseyoutubelesson.R
import com.giftofhappiness.roomdatabaseyoutubelesson.data.User
import com.giftofhappiness.roomdatabaseyoutubelesson.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.coroutines.InternalCoroutinesApi

class ListFragment : Fragment() {
@InternalCoroutinesApi
private lateinit var mUserViewModel: UserViewModel

    @InternalCoroutinesApi
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel = ViewModelProvider(this,).get(UserViewModel::class.java)
       //view life cycle owner was originally this.
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
        adapter.setData(user)})



        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        return view
    }


  }