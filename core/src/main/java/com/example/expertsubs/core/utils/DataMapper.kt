package com.example.expertsubs.core.utils

import com.example.expertsubs.core.data.source.local.entity.UserEntity
import com.example.expertsubs.core.data.source.remote.response.ItemsItem
import com.example.expertsubs.core.domain.model.Users

object DataMapper {

    fun mapResponsesToEntities(input: List<ItemsItem>): List<UserEntity> {
        val userList = ArrayList<UserEntity>()
        input.map { data ->
            data.apply {
                val user = UserEntity(
                    usersId = id,
                    title = login,
                    description = url,
                    image = avatarUrl,
                    repo= reposUrl,
                    isFavorite = false
                )
                userList.add(user)
            }
        }
        return userList
    }

    fun mapEntitiesToDomain(input: List<UserEntity>): List<Users> =
        input.map {
            Users(
                usersId = it.usersId,
                username = it.title,
                description = it.description,
                image = it.image,
                repo = it.repo,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Users) = UserEntity(
        usersId = input.usersId,
        title = input.username,
        description = input.description,
        image = input.image,
        repo = input.repo,
        isFavorite = input.isFavorite
    )


}