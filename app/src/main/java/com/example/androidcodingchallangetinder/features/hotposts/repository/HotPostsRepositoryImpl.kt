package com.example.androidcodingchallangetinder.features.hotposts.repository

import android.util.Log
import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import com.example.androidcodingchallangetinder.features.hotposts.service.HotPostsService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotPostsRepositoryImpl @Inject constructor(
    private val hotPostsService: HotPostsService
)  : HotPostsRepository {

    override fun getAllHotPosts(): Flow<HotPostsResponseModel> = flow {
        val response = hotPostsService.getAllHotPosts()
        Log.d( "BooksRepositoryImpl", "$response")
        emit(response)
    }
}