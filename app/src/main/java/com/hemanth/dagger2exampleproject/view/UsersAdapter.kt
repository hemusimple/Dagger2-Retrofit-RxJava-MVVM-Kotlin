package com.hemanth.dagger2exampleproject.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hemanth.dagger2exampleproject.R
import com.hemanth.dagger2exampleproject.model.User
import kotlinx.android.synthetic.main.users_list_row.view.*

class  UsersAdapter (var users:ArrayList<User>):RecyclerView.Adapter<UsersAdapter.UserViewHolder>(){

    fun  refresh(upatedData:ArrayList<User>){
        this.users.clear()
        this.users.addAll(upatedData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder= UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.users_list_row,parent,false))

    override fun getItemCount(): Int =users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(users[position])
    }


    class  UserViewHolder(view:View):RecyclerView.ViewHolder(view){

        var usertext =view.username
        fun bindData(user:User){
            usertext.text = user.username
        }
    }
}