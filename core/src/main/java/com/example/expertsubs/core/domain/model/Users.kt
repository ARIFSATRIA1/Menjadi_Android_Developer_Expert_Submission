package com.example.expertsubs.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    val usersId: Int,
    val username: String,
    val description: String,
    val image: String,
    val repo: String,
    val isFavorite: Boolean
): Parcelable
