package com.example.expertsubs.core.domain.usecase


import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.repository.IUserRepository
import javax.inject.Inject

class GithubUserInteractor @Inject constructor(private val userRepository: IUserRepository): GithubUserUseCase {
    override fun getAllGithubUsers() = userRepository.getAllGithubUsers()

    override fun getFavoriteGithubUsers() = userRepository.getFavoriteGithubUsers()

    override fun setFavoriteGithubUsers(users: Users, state: Boolean) = userRepository.setFavoriteGithubUsers(users, state)


}