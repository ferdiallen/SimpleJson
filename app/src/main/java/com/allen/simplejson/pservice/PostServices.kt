package com.allen.simplejson.pservice

import com.allen.simplejson.data.PostValuesData
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

interface PostServices {
    suspend fun getDataComment(): List<PostValuesData>

    companion object {
        fun create(): PostServices {
            return PostServiceImpl(
                client =
                HttpClient(Android) {
                    this.install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}