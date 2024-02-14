package com.example.expertsubs.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.expertsubs.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllGithubUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM user WHERE isFavorite = 1")
    fun getFavoriteGithubUsers(): Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGithubUsers(user: List<UserEntity>)

    @Update
    fun updateGithubUsers(user: UserEntity)

}