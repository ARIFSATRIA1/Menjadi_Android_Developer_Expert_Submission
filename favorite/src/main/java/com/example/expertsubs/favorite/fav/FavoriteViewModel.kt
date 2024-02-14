package com.example.expertsubs.favorite.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expertsubs.core.domain.usecase.GithubUserUseCase


class FavoriteViewModel(githubUserUseCase: GithubUserUseCase): ViewModel() {
    val favoriteUser = githubUserUseCase.getFavoriteGithubUsers().asLiveData()
}