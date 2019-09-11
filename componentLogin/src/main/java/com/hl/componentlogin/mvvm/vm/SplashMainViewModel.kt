package com.hl.componentlogin.mvvm.vm

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.hl.corelib.LiveDataViewModel

class SplashMainViewModel(application: Application) : LiveDataViewModel(application) {
    //数据绑定到界面方式一
    val _lastName = MutableLiveData("Lovelace")

    //数据绑定到界面方式二
    val lastName = ObservableField("Lovelace")

    init {
        _lastName.value = "current thread is 1 ${Thread.currentThread()}"

        lastName.set("current thread is 2 ${Thread.currentThread()}")

        //TODO 两种方式可以将参数回传 在activity中监听即可
        currentName.value = "11"
        currentName.postValue("22")
    }

    /**
     * 添加点击事件
     */
    fun nameOnClick() {
        println("observer 点击我了 ${lifecycle.currentState}")
    }
}