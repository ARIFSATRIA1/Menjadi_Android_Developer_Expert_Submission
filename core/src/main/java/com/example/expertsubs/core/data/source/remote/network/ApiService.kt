package com.example.expertsubs.core.data.source.remote.network

import com.example.expertsubs.core.data.source.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    suspend fun getUsersData(
        @Query("q") query: String = "a"
    ): UserResponse
}