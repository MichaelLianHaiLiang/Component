package com.hl.myapp.jetpack.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hl.myapp.jetpack.room.model.RoomModel

@Dao
interface RoomModelDao {

    /**
     * 1. OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务。

    2. OnConflictStrategy.ROLLBACK：冲突策略是回滚事务。

    3. OnConflictStrategy.ABORT：冲突策略是终止事务。

    4. OnConflictStrategy.FAIL：冲突策略是事务失败。

    5. OnConflictStrategy.IGNORE：冲突策略是忽略冲突。
     */
    //增
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomModel(model: RoomModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoomModelList(model: List<RoomModel>)

    //删
    @Query("delete from MyTable")
    fun delete()

    //改
    @Update
    fun updateRoomModel(model: RoomModel)

    @Update
    fun updateRoomModelList(model: List<RoomModel>)

    //查
    @Query("select * from MyTable where name = :name")
    fun queryRoomModel(name: String): RoomModel

    @Query("select * from MyTable")
    fun queryAllRoomModel(): List<RoomModel>

    //通过 LiveData 可以监听数据中数据变化
    @Query("select * from MyTable")
    fun syncQueryRoomModel(): LiveData<List<RoomModel>>

}