package com.example.expertsubs.favorite.fav

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expertsubs.core.domain.usecase.GithubUserUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val githubUserUseCase: GithubUserUseCase): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
         when {
            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
                FavoriteViewModel(githubUserUseCase) as T
            } else -> {
                throw Throwable("Unknown ViewModel class: " + modelClass.name)
            }
        }


}