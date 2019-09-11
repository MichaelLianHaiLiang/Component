package com.hl.myapp.jetpack.room.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


object DataMigration {


    /**
     * 表中添加字段 只能一个一个字段添加
     * 手写SQL语句，必须保证与创建的实体类中的注解完全一致，不然会报错, bean会根据注解自动生成对应的 sql 语句
     * bean中定义字段必须与升级出字段保持一致,同时bean中字段默认是 NOT NULL 为true ,需要此处注意 添加默认值
     * 当添加int 类型数据时，需要添加默认值
     */
    var version1To2: Migration = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("ALTER TABLE '" + XxConstant.Database.LOGIN_TABLE_NAME + "' ADD 'vip' INTEGER NOT NULL DEFAULT '0'")
//            database.execSQL("ALTER TABLE '" + XxConstant.Database.USER_DETAILS_TABLE_NAME + "' ADD 'vip' INTEGER NOT NULL DEFAULT '0'")
        }
    }
    var version2To3: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("ALTER TABLE '" + XxConstant.Database.USER_DETAILS_TABLE_NAME + "' ADD 'myCouponNumber' INTEGER NOT NULL DEFAULT '0'")
        }
    }

    /**
     * 添加表
     */
    var version4To5: Migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("CREATE TABLE '" + XxConstant.Database.COMMONINFO_TABLE_NAME + "' ('accid' TEXT,'age' INTEGER,'avStatus' INTEGER, 'city' TEXT,'connectNumber' INTEGER, 'connectRate' REAL, 'constellation' TEXT, 'cover' TEXT, 'followStatus' INTEGER,'gender' INTEGER,'intro' TEXT, 'name' TEXT, 'onLineStatus' INTEGER, 'openVideo' INTEGER, 'openVoice' INTEGER, 'province' TEXT, 'videoIntro' TEXT, 'videoPrice' INTEGER, 'voiceIntro' TEXT, 'voicePrice' INTEGER,PRIMARY KEY(`accid`))")
        }
    }

}