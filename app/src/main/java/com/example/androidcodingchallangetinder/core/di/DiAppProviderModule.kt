package com.example.androidcodingchallangetinder.core.di

import com.example.androidcodingchallangetinder.features.hotposts.model.Post
import com.example.androidcodingchallangetinder.features.hotposts.service.HotPostsService
import com.example.androidcodingchallangetinder.features.hotposts.ui.PostsListAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

/**@ViewModelComponent: Scoping to viewmodel so that instance is saved across configuration changes
 * @ViewModelScoped //Scoping to viewmodel so that instance is saved across configuration changes
 * */
@Module
@InstallIn(ViewModelComponent::class)
class DiAppProviderModule {

    @Provides
    @ViewModelScoped
    fun provideHotPostsService(retrofit: Retrofit): HotPostsService {
        return retrofit.create(HotPostsService::class.java)
    }
}