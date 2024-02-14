package com.example.expertsubs.core.di

import com.example.expertsubs.core.domain.usecase.GithubUserUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavModuleDependencies {

    fun userUseCase(): GithubUserUseCase
}