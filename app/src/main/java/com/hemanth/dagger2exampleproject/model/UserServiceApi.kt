package com.hemanth.dagger2exampleproject.model

import io.reactivex.Single
import retrofit2.http.GET


interface  UserServiceApi{

    @GET("/hemusimple/Demo/master/Users.json")
    fun getUsersData(): Single<Users>
}