package com.example.expertsubs.core.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userId")
    var usersId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo("description")
    var description: String,

    @ColumnInfo(name = "image")
    var image: String,

    @ColumnInfo(name = "repo")
    var repo: String,

    @ColumnInfo("isFavorite")
    var isFavorite: Boolean = false

): Parcelable
