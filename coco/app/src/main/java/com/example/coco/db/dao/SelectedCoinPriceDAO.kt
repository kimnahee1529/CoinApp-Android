package com.example.coco.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coco.db.entity.SelectedCoinPriceEntity

@Dao
interface SelectedCoinPriceDAO {

    //getAllData : 전체 데이터 가져오기
    @Query("SELECT * FROM selected_coin_price_table")
    fun getAllData() : List<SelectedCoinPriceEntity>

    //insert : 데이터 저장하기
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(selectedCoinPriceEntity: SelectedCoinPriceEntity)

    //하나의 코인에 대해서 저장된 정보를 가져오기
    //: 현재가격 15, 30, 45분 전 가격이 어떻게 변화했는지 DB에 저장된 값과 비교하는 용도
    @Query("SELECT * FROM selected_coin_price_table WHERE coinName = :coinName")
    fun getOneCoinData(coinName : String) : List<SelectedCoinPriceEntity>

}