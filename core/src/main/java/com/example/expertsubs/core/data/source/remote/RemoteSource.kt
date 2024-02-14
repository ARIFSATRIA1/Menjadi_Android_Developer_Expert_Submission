package com.example.expertsubs.core.data.source.remote

import com.example.expertsubs.core.data.source.remote.network.ApiResponse
import com.example.expertsubs.core.data.source.remote.network.ApiService
import com.example.expertsubs.core.data.source.remote.response.ItemsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteSource @Inject constructor(private val apiService: ApiService) {


    suspend fun getAllUser(): Flow<ApiResponse<List<ItemsItem>>> =
        flow {
            try {
                val response = apiService.getUsersData()
                val data = response.items
                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(data))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
}