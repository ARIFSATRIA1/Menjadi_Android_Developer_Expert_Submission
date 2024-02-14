package com.example.expertsubs.core.domain.repository

import com.example.expertsubs.core.data.source.Resource
import com.example.expertsubs.core.domain.model.Users
import kotlinx.coroutines.flow.Flow

interface IUserRepository {

    fun getAllGithubUsers(): Flow<Resource<List<Users>>>

    fun getFavoriteGithubUsers(): Flow<List<Users>>

    fun setFavoriteGithubUsers(users: Users, state: Boolean)

}