package com.sopt.dive.data.di

import com.sopt.dive.data.repositoryimpl.auth.AuthRepositoryImpl
import com.sopt.dive.data.repositoryimpl.home.HomeRepositoryImpl
import com.sopt.dive.data.repositoryimpl.my.MyPageRepositoryImpl
import com.sopt.dive.domain.repository.auth.AuthRepository
import com.sopt.dive.domain.repository.home.HomeRepository
import com.sopt.dive.domain.repository.my.MyPageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindMyPageRepository(
        myPageRepositoryImpl: MyPageRepositoryImpl
    ): MyPageRepository

    @Binds
    @Singleton
    abstract fun bineHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository
}