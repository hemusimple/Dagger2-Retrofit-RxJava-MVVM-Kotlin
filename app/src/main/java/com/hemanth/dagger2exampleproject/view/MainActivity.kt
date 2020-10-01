package com.hemanth.dagger2exampleproject.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hemanth.dagger2exampleproject.R
import com.hemanth.dagger2exampleproject.viewmodel.UsersViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var userAdapter=UsersAdapter(arrayListOf())
    lateinit var  uservViewModel :UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uservViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        users_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
            setHasFixedSize(true)
        }
        uservViewModel.getUsersData()
        observers()
    }


    fun observers(){
        uservViewModel.users.observe(this, Observer { users->users.let { userAdapter.refresh(users.users) } })
        uservViewModel.error.observe(this, Observer { error->error.let {if(error) Toast.makeText(this,"Error occurred",Toast.LENGTH_LONG).show() } })
    }

}
