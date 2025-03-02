package com.example.citiesapp.di

import android.content.Context
import com.example.citiesapp.repository.CitiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    @ViewModelScoped
    fun provideCitiesRepository(@ApplicationContext context: Context): CitiesRepository {
        return CitiesRepository(context)
    }
}