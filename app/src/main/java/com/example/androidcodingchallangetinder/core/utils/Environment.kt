package com.example.androidcodingchallangetinder.core.utils

import javax.inject.Inject

interface Environment {
    val baseUrl: String
    val buildVersion: String
}
class EnvironmentImpl @Inject constructor(): Environment {
    override val baseUrl: String = "https://reddit.com/"
    override val buildVersion: String = ""
}