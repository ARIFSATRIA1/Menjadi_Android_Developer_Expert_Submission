package com.example.expertsubs.core.di

import android.content.Context
import androidx.room.Room
import com.example.expertsubs.core.data.source.local.room.UserDao
import com.example.expertsubs.core.data.source.local.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    val passphrase: ByteArray = SQLiteDatabase.getBytes("codext".toCharArray())
    val factory = SupportFactory(passphrase)
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): UserDatabase = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        "Users.db"
    )
        .fallbackToDestructiveMigration()
        .openHelperFactory(factory)
        .build()

    @Provides
    fun provideUserDao(database: UserDatabase): UserDao = database.githubDao()

}