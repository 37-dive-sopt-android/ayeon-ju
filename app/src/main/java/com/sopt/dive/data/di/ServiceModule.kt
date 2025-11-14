package com.sopt.dive.data.di

import com.sopt.dive.data.service.auth.AuthService
import com.sopt.dive.data.service.my.MyPageService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): AuthService = retrofit.create(
        AuthService::class.java
    )

    @Provides
    @Singleton
    fun providesMyPageService(retrofit: Retrofit): MyPageService = retrofit.create(
        MyPageService::class.java
    )
}