package com.example.expertsubs.di

import com.example.expertsubs.core.domain.usecase.GithubUserInteractor
import com.example.expertsubs.core.domain.usecase.GithubUserUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGithubUseCase(userInteractor: GithubUserInteractor): GithubUserUseCase
}