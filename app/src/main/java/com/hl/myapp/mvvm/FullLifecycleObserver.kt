package com.hl.myapp.mvvm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 *  Created by Napto on 2019/3/6 12:29
 *
 */
interface FullLifecycleObserver : LifecycleObserver {

    fun onCreate(owner: LifecycleOwner)

    fun onStart(owner: LifecycleOwner)

    fun onResume(owner: LifecycleOwner)

    fun onPause(owner: LifecycleOwner)

    fun onStop(owner: LifecycleOwner)

    fun onDestroy(owner: LifecycleOwner)

}