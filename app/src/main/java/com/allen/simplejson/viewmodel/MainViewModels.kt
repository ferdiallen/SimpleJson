package com.allen.simplejson.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allen.simplejson.data.PostValuesData
import com.allen.simplejson.pservice.PostServices
import kotlinx.coroutines.launch

class MainViewModels : ViewModel() {
    private var _data = MutableLiveData<List<PostValuesData>>()
    val data: LiveData<List<PostValuesData>> = _data
    private val serviceAPI = PostServices.create()
    suspend fun tester(): List<PostValuesData> {
        return serviceAPI.getDataComment()
    }
}