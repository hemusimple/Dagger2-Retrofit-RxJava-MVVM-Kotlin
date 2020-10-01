package com.hemanth.dagger2exampleproject.dinjection

import com.hemanth.dagger2exampleproject.model.UserService
import com.hemanth.dagger2exampleproject.viewmodel.UsersViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface  MainComponent{

    fun  injectService( userService: UserService)
    fun injectUserViewModel(userViewMode:UsersViewModel)
}