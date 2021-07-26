package com.example.test

import com.example.test.model.UserDataResponseItem
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
):IHomeRepository {

    override suspend fun getAllUser(): MutableList<UserDataResponseItem> {
        return remoteDataSource.getAllArticle()
    }

}