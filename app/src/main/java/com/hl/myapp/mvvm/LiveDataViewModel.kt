package com.hl.myapp.mvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * LiveData 不仅仅监听某一参数值的变化 还可监听数据中数据变化 然后对应做一些操作
 */
abstract class LiveDataViewModel(application: Application) : LifeCycleViewModel(application) {

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {

        /**
         * ViewModel.viewModelScope 扩展函数
         */
        viewModelScope.launch {
            //ViewModel中协程使用
        }
    }

}