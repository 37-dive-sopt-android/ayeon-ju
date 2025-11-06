package com.sopt.dive.data.di

import android.content.Context
import android.content.SharedPreferences
import com.sopt.dive.core.util.KeyStorage.USER_PREFS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(
        @ApplicationContext context: Context
    ): SharedPreferences {
        return context.getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
    }
}