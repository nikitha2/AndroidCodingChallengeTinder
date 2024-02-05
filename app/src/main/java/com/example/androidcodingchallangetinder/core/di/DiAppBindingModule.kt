package com.example.androidcodingchallangetinder.core.di

import com.example.androidcodingchallangetinder.features.hotposts.repository.HotPostsRepository
import com.example.androidcodingchallangetinder.features.hotposts.repository.HotPostsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**@ViewModelComponent: Scoping to viewmodel so that instance is saved across configuration changes
 * @ViewModelScoped //Scoping to viewmodel so that instance is saved across configuration changes
 * */
@Module
@InstallIn(ViewModelComponent::class)
abstract class DiAppBindingModule {

    /** As HotPostsRepository is injected in view model. */
    @Binds
    @ViewModelScoped
    abstract fun bindHotPostsRepository(
        hotPostsRepositoryImpl: HotPostsRepositoryImpl
    ): HotPostsRepository

}