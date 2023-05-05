package com.example.coco.repository

import com.example.coco.db.network.API
import com.example.coco.db.network.RetrofitInstance
import retrofit2.Retrofit

class NetWorkRepository {

    private val client = RetrofitInstance.getInstance().create(API::class.java)

    suspend fun getCurrentCoinList() = client.getCurrentCoinList()

    suspend fun getInterestCoinPriceData(coin : String) = client.getRecentCoinPrice(coin)

}