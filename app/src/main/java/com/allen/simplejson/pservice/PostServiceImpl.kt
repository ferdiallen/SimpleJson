package com.allen.simplejson.pservice

import com.allen.simplejson.data.PostValuesData
import com.allen.simplejson.urls.Routes
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import java.lang.Exception

class PostServiceImpl(private val client: HttpClient) : PostServices {
    override suspend fun getDataComment(): List<PostValuesData> {
        return try {
            client.get {
                url(Routes.GET_COMMENTS)
            }
        } catch (e: Exception) {
            println("${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            println(e.response.status.description)
            emptyList()
        }
    }
}