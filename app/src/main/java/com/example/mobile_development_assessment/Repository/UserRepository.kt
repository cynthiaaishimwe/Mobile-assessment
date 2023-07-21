package com.example.mobile_development_assessment.Repository

import com.example.mobile_development_assessment.API.ApiClient
import com.example.mobile_development_assessment.API.Apiinterface
import com.example.mobile_development_assessment.Model.RegisterRequest
import com.example.mobile_development_assessment.Model.RegisterResponse
//import com.example.mobile_development_assessment.apiinterface.Apiinterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//import okhttp3.Dispatcher
//import okhttp3.Dispatcher
import retrofit2.Response

//import okhttp///3.Dispatcher
//import okhttp3.Response


class UserRepository {
    var apiClient=ApiClient.buildClient(Apiinterface::class.java)
    suspend fun registerUser(RegisterRequest: RegisterRequest):
            Response<RegisterResponse> {
        return withContext(Dispatchers.IO){
            apiClient.registerUser(RegisterRequest)
        }
    }
}