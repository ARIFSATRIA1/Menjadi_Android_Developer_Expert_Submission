package com.example.expertsubs.core.domain.usecase

import com.example.expertsubs.core.data.source.Resource
import com.example.expertsubs.core.domain.model.Users
import kotlinx.coroutines.flow.Flow


interface GithubUserUseCase {
    fun getAllGithubUsers(): Flow<Resource<List<Users>>>

    fun getFavoriteGithubUsers(): Flow<List<Users>>

    fun setFavoriteGithubUsers(users: Users, state: Boolean)
}