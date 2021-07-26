package com.example.test

import com.example.test.api.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllArticle() =
        apiService.getAllArticle()
}