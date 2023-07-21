package com.example.mobile_development_assessment.ViewModel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contact_page.R
import com.example.mobile_development_assessment.Model.RegisterRequest
import com.example.mobile_development_assessment.Model.RegisterResponse
import com.example.mobile_development_assessment.Repository.UserRepository
import kotlinx.coroutines.launch


class UserViewModels:ViewModel() {
    val regLiveData= MutableLiveData<RegisterResponse>()
    val errorLiveData=MutableLiveData<String>()
    val  userRepository= UserRepository()


    fun registerUser(regesterRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(regesterRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}