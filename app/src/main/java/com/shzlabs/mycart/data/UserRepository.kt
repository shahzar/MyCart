package com.shzlabs.mycart.data

import com.shzlabs.mycart.data.remote.ApiService
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSrc: ApiService
): BaseRepository() {

    suspend fun getUserCartItems() = safeApiCall {
        return@safeApiCall remoteDataSrc.getCartItems()
    }


}