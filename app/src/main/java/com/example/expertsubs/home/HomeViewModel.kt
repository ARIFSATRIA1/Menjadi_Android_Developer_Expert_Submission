package com.example.expertsubs.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.expertsubs.core.domain.usecase.GithubUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(useCase: GithubUserUseCase): ViewModel() {
    val github = useCase.getAllGithubUsers().asLiveData()
}