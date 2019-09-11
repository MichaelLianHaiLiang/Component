package com.hl.myapp

import com.hl.corelib.CoreApplication

class MyApplication : CoreApplication() {

    companion object {
        lateinit var INSTANCE: MyApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    //Kotlin中使用 out / in 设定泛型的上界与下界
    //in 相当于Java中 ? super T
    //out 相当于Java中? extends T

}