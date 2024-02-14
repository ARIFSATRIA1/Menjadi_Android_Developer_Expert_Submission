package com.example.expertsubs.favorite.fav

import android.content.Context
import com.example.expertsubs.core.di.FavModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(dependencies = [FavModuleDependencies::class])
interface FavoriteModule {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {

        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favModuleDependencies: FavModuleDependencies): Builder
        fun build(): FavoriteModule
    }
}