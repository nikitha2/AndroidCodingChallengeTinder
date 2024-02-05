package com.example.androidcodingchallangetinder.core.di

import com.example.androidcodingchallangetinder.core.utils.Environment
import com.example.androidcodingchallangetinder.core.utils.EnvironmentImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DiSingletonBindingModule {

    /** because Environment is used in provideRetrofitWithBaseUrl which is a singleton
     * same scope should be used for bindEnvironment
     * */
    @Binds
    @Singleton
    abstract fun bindEnvironment(
        environmentImpl: EnvironmentImpl
    ): Environment

}