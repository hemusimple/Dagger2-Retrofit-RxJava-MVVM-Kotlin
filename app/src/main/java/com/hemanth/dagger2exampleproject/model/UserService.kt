package com.hemanth.dagger2exampleproject.model

import com.hemanth.dagger2exampleproject.dinjection.DaggerMainComponent
import io.reactivex.Single

import javax.inject.Inject

class  UserService{

    @Inject
    lateinit var userApi:UserServiceApi

    init {
       DaggerMainComponent.create().injectService(this)
    }

    fun  getUsersData():Single<Users>{
        return  userApi.getUsersData()
    }
}