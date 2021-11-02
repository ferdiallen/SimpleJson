package com.allen.simplejson.viewmodel

import androidx.lifecycle.ViewModel
import com.allen.simplejson.data.PostValuesData
import com.allen.simplejson.pservice.PostServices

class MainViewModels : ViewModel() {
    private val serviceAPI = PostServices.create()
    suspend fun tester(): List<PostValuesData> {
        return serviceAPI.getDataComment()
    }
}