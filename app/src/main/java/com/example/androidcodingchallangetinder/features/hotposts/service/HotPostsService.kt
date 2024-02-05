package com.example.androidcodingchallangetinder.features.hotposts.service

import com.example.androidcodingchallangetinder.features.hotposts.model.HotPostsResponseModel
import retrofit2.http.GET

/**
 * The interface holds the api endpoints for the hotPosts module.
 */
interface HotPostsService {
    @GET("r/aww/hot.json")
    suspend fun getAllHotPosts(): HotPostsResponseModel
}