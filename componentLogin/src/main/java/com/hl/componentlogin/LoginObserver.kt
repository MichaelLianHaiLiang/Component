package com.hl.componentlogin

import androidx.lifecycle.MutableLiveData

/**
 * @Author: maijie20180425
 * Time: 2019/9/11
 * Description:
 */
object LoginObserver {

    /**
     * 0 代表失败
     * 1 代表成功
     */
    val loginResult: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

}