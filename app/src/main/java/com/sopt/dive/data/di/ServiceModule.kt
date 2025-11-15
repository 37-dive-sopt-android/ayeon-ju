package com.sopt.dive.data.di

import com.sopt.dive.core.network.qualifier.MainRetrofit
import com.sopt.dive.core.network.qualifier.OpenRetrofit
import com.sopt.dive.data.service.auth.AuthService
import com.sopt.dive.data.service.home.HomeService
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
    fun providesAuthService(@MainRetrofit retrofit: Retrofit): AuthService = retrofit.create(
        AuthService::class.java
    )

    @Provides
    @Singleton
    fun providesMyPageService(@MainRetrofit retrofit: Retrofit): MyPageService = retrofit.create(
        MyPageService::class.java
    )

    @Provides
    @Singleton
    fun providesHomeService(@OpenRetrofit retrofit: Retrofit): HomeService = retrofit.create(
        HomeService::class.java
    )
}