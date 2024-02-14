package com.example.expertsubs.detail

import androidx.lifecycle.ViewModel
import com.example.expertsubs.core.domain.model.Users
import com.example.expertsubs.core.domain.usecase.GithubUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val githubUserUseCase: GithubUserUseCase): ViewModel() {
    fun setFavoriteGithubUsers(users: Users, state: Boolean) {
        githubUserUseCase.setFavoriteGithubUsers(users, state)
    }
}