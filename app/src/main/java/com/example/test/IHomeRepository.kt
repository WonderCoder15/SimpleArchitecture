package com.example.test

import com.example.test.model.UserDataResponseItem

interface IHomeRepository {
    suspend fun getAllUser(): MutableList<UserDataResponseItem>
}