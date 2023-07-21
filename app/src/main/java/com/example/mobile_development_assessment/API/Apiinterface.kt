package com.example.mobile_development_assessment.API

import com.example.mobile_development_assessment.Model.RegisterRequest
import com.example.mobile_development_assessment.Model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Apiinterface {
    @POST("/users/register")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>
}