package com.hemanth.dagger2exampleproject.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hemanth.dagger2exampleproject.dinjection.DaggerMainComponent
import com.hemanth.dagger2exampleproject.model.UserService
import com.hemanth.dagger2exampleproject.model.Users
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UsersViewModel : ViewModel() {
    @Inject
   lateinit var userService:UserService

    init {
DaggerMainComponent.create().injectUserViewModel(this)
    }


    var users = MutableLiveData<Users>()
    var error = MutableLiveData<Boolean>()


    fun getUsersData() {
        getRefreshedUsersData()
    }

    private fun getRefreshedUsersData() {
       userService.getUsersData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(object:DisposableSingleObserver<Users>(){
           override fun onSuccess(t: Users) {
               users.value = t
               error.value = false
           }

           override fun onError(e: Throwable) {
               error.value = true
           }
       })
    }
}