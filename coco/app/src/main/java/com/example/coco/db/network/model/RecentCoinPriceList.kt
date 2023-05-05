package com.example.coco.db.network.model

import com.example.coco.dataModel.RecentPriceData

data class RecentCoinPriceList (

    val status : String,
    val data : List<RecentPriceData>

    )