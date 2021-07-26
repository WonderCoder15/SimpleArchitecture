package com.example.test.api

import com.example.test.model.UserDataResponseItem
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getAllArticle(): MutableList<UserDataResponseItem>
}