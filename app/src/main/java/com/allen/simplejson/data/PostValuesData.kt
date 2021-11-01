package com.allen.simplejson.data

import kotlinx.serialization.Serializable

@Serializable
data class PostValuesData(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)