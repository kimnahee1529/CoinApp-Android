package com.example.coco.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.coco.db.entity.InterestCoinEntity
import kotlinx.coroutines.flow.Flow

//쿼리를 날림 DAO : 쿼리를 정의해 주는 곳
@Dao
interface InterestCoinDAO {

    //getAllData : 전체 데이터 다 가져오기
    //데이터의 변경 사항을 감지하기 좋다
    @Query("SELECT * FROM interest_coin_table")
    fun getAllData() : Flow<List<InterestCoinEntity>>

    //Insert : 데이터 집어넣기
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(interestCoinEntity: InterestCoinEntity)

    //Update : 관심있어 하는지 아닌지를 업데이트
    //사용자가 코인 데이터를 선택했다가 다시 취소할 수도 있고, 반대로 선택안된 것을 선택할 수도 있게 함
    @Update
    fun update(interestCoinEntity: InterestCoinEntity)

    //getSelectedCoinList : 내가 관심있어한 코인 데이터를 가져오는 것
    @Query("SELECT * FROM interest_coin_table WHERE selected = :selected")
    fun getSelectedData(selected : Boolean = true) : List<InterestCoinEntity>
}