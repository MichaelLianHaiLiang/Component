package com.hl.corelib

import androidx.multidex.MultiDexApplication


/**
 * @Author: maijie20180425
 * Time: 2019/9/10
 * Description:
 *
//Kotlin中使用 out / in 设定泛型的上界与下界
//in 相当于Java中 ? super T
//out 相当于Java中? extends T
 */
open class CoreApplication : MultiDexApplication() {

    companion object {
        lateinit var INSTANCE: CoreApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

}