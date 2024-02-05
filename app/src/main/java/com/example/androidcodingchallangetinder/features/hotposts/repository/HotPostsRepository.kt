package com.example.androidcodingchallangetinder.features.hotposts.repository

import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import kotlinx.coroutines.flow.Flow

interface HotPostsRepository {
    fun getAllHotPosts(): Flow<HotPostsResponseModel>
}