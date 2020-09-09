package com.giftofhappiness.roomdatabaseyoutubelesson.fragements.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.giftofhappiness.roomdatabaseyoutubelesson.R
import com.giftofhappiness.roomdatabaseyoutubelesson.data.User
import kotlinx.android.synthetic.main.custom_view.view.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){






    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_view,parent,false))
    }


    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.idTxtBox.text = currentItem.id.toString()
        holder.itemView.firstNameTxtRecView.text = currentItem.firstName.toString()
        holder.itemView.lastNameTxtboxRecView.text = currentItem.lastName.toString()
        holder.itemView.ageTxtBoxRecView.text = currentItem.age.toString()
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()



    }



}