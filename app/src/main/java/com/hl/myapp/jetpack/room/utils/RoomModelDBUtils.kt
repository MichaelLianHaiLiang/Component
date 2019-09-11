package com.hl.myapp.jetpack.room.utils

import androidx.lifecycle.LiveData
import com.hl.myapp.getApplicaiton
import com.hl.myapp.jetpack.room.dao.RoomModelDao
import com.hl.myapp.jetpack.room.db.AppDatabase
import com.hl.myapp.jetpack.room.model.RoomModel

object RoomModelDBUtils : RoomModelDao {

    var roomModelDao = AppDatabase.getInstance(getApplicaiton()).roomModelDao()

    override fun insertRoomModel(model: RoomModel) {
        roomModelDao.insertRoomModel(model)
    }

    override fun insertRoomModelList(model: List<RoomModel>) {
        roomModelDao.insertRoomModelList(model)
    }

    override fun delete() {
        roomModelDao.delete()
    }

    override fun updateRoomModel(model: RoomModel) {
        roomModelDao.updateRoomModel(model)
    }

    override fun updateRoomModelList(model: List<RoomModel>) {
        roomModelDao.updateRoomModelList(model)
    }

    override fun queryRoomModel(name: String): RoomModel {
        return roomModelDao.queryRoomModel(name)
    }

    override fun queryAllRoomModel(): List<RoomModel> {
        return roomModelDao.queryAllRoomModel()
    }

    override fun syncQueryRoomModel(): LiveData<List<RoomModel>> {
        return roomModelDao.syncQueryRoomModel()
    }
}