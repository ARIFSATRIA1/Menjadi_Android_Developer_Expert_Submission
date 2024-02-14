package com.example.expertsubs.core.data.source.local

import com.example.expertsubs.core.data.source.local.entity.UserEntity
import com.example.expertsubs.core.data.source.local.room.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val userDao: UserDao){


    fun getAllAnime(): Flow<List<UserEntity>>  = userDao.getAllGithubUsers()

    fun getFavoriteAnime(): Flow<List<UserEntity>> = userDao.getFavoriteGithubUsers()

    fun insertTourism(animeList: List<UserEntity>) = userDao.insertGithubUsers(animeList)

    fun setFavoriteAnime(userEntity: UserEntity, newState: Boolean) {
        userEntity.isFavorite = newState
        userDao.updateGithubUsers(userEntity)
    }

}