package com.example.androidcodingchallangetinder.features.hotposts.model

import java.io.Serializable

data class HotPostsResponseModel(
    val data: HotPostsResponse? = null
) : Serializable

data class HotPostsResponse(
    val children: List<Post>
) : Serializable

data class Post(
    val data: Data? = null
) : Serializable


data class Date(
    val after: String? = null,
    val dist: Int = 0,
    val modhash: String? = null,
    val geo_filter: String? = null
) : Serializable

data class Data(
    val title: String? = null,
    val name: String? = null,
    val selftext: String? = null,
    val thumbnail: String = "self",
    val url: String? = null,
    val secure_media: SecureMedia? = null,
    val media: SecureMedia? = null,
    val is_video: Boolean = false
) : Serializable

data class SecureMedia(
    val reddit_video: RedditVideo? = null
) : Serializable

data class RedditVideo(
    val fallback_url: String? = null,
    val dash_url: String? = null,
    val hls_url: String? = null,
) : Serializable