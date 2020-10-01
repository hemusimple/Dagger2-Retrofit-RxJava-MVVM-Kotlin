package com.hemanth.dagger2exampleproject.dinjection

import com.hemanth.dagger2exampleproject.model.UserService
import com.hemanth.dagger2exampleproject.model.UserServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class  AppModule{

  private  val BASE_URL :String = "https://raw.githubusercontent.com"

    @Provides
    fun  getRetrofit():UserServiceApi {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(UserServiceApi::class.java)
    }

    @Provides
    fun  getUserService():UserService{
        return  UserService()
    }

}