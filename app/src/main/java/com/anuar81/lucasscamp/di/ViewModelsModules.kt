package com.anuar81.lucasscamp.di

import android.content.Context
import com.anuar81.lucasscamp.data.LoginRepository
import com.anuar81.lucasscamp.data.ServiceDBRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelsModules {

    @Provides
    @ViewModelScoped
    fun provideLoginRepository(@ApplicationContext appContext: Context): LoginRepository {
        return LoginRepository(appContext)
    }

    @Provides
    @ViewModelScoped
    fun provideServiceDBRepository(): ServiceDBRepository {
        return ServiceDBRepository()
    }
}