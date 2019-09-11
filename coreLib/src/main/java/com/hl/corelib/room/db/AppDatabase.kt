package com.hl.corelib.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hl.corelib.room.dao.RoomModelDao
import com.hl.corelib.room.migration.DataMigration
import com.hl.corelib.room.model.RoomModel

@Database(entities = [RoomModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomModelDao(): RoomModelDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "appInfo.db")
                .allowMainThreadQueries()
                .addMigrations(DataMigration.version1To2)
                .addMigrations(DataMigration.version2To3)
                .build()

    }
}