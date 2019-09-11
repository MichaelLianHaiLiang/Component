package com.hl.myapp.mvvm

import android.app.Application
import android.content.Context
import androidx.lifecycle.*

/**
 * 此处将Activity的生命周期与ViewModel的生命周期关联到一起
 *
 * Activity的生命周期变化 ---> LifecycleRegistry处理 ---> LifecycleOwner
 * 使用时 getLifecycle() 即可获取与Activity一致的生命周期
 *
 * RxJava中网络请求需要传入lifecycleOwner时 直接传入 getLifecycle() 如此网络请求受Activity生命控制
 * LifecycleOwner lifecycleOwner = mLifecycleOwner.get();
 *
 * TODO 如此不仅仅是 ViewModel 可以与Activity生命周期绑定,任何类可以通过类似方式与Activity生命周期进行绑定
 */
abstract class LifeCycleViewModel(application: Application) : AndroidViewModel(application), LifecycleOwner,
    LifecycleObserver, ExtContext {

    val mLifecycleRegistry: LifecycleRegistry by lazy { LifecycleRegistry(this) }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestory() {
        mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        println("observer ViewModel ${lifecycle.currentState}")
    }

    override fun getExtensionContext(): Context {
        return getApplication()
    }

}