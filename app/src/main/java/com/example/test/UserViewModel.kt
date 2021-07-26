package com.example.test

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.UserDataResponseItem
import com.example.test.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val homeRepository: UserRepository
) : ViewModel() {

    val userResponse =
        MutableLiveData<Resource<MutableList<UserDataResponseItem>>>()


    fun getAllArticle() {
        userResponse.postValue(Resource.loading(null))

        viewModelScope.launch {
            // this is main threas
            try {
                //fetching response in background
                withContext(Dispatchers.IO)
                {
                    val response = homeRepository.getAllUser()
                    Log.d("ViewModel response", "$response")
                    userResponse.postValue(Resource.success(response))
                }
            } catch (ex: Exception) {
                userResponse.postValue(Resource.error(ex.toString(), null))
            }
        }
    }
}