package com.example.androidcodingchallangetinder.core.di

import com.example.androidcodingchallangetinder.core.utils.Environment
import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import com.example.androidcodingchallangetinder.features.hotposts.model.Post
import com.example.androidcodingchallangetinder.features.hotposts.ui.PostsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DiSingletonProviderModule {

    @Provides
    @Singleton
    fun provideRetrofitWithBaseUrl(environment: Environment): Retrofit {
        return Retrofit.Builder()
            .baseUrl(environment.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideHotPostsResponseModel(): HotPostsResponseModel {
        return HotPostsResponseModel()
    }
}