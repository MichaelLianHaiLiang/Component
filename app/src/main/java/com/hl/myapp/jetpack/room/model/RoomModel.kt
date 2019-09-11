package com.hl.myapp.jetpack.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "MyTable")
data class RoomModel(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    var id: Int,
    var name: String,
    var password: String

)