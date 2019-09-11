package com.hl.myapp.mvvm.view

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hl.myapp.R
import com.hl.myapp.databinding.ActivityMainBinding
import com.hl.myapp.mvvm.ExtContext
import com.hl.myapp.mvvm.vm.MainViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), ExtContext {

    /**
     * 维护共同的上下文
     */
    override fun getExtensionContext(): Context {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TODO databinding
        //TODO 第一步 Obtain ViewModel from ViewModelProviders
        val mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java) //过时方法

        //TODO 第二步 添加监听生命周期拥有者的生命周期 Activity与ViewModel生命周期一致
        //这一步非常重要 需要绑定到 databinding的ViewModel与添加生命周期监听的ViewModel一样的才可以
        lifecycle.addObserver(mainViewModel)

        // Obtain binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind layout with ViewModel
        binding.viewmodel = mainViewModel

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
        //TODO 思考题 ViewModel与Activity生命周期如何关联的
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //TODO 协程简单使用
//        startCoroutine()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //TODO Android Ktx 扩展很多方法 简化代码
        getSharedPreferences("name", Activity.MODE_PRIVATE).edit {
            putLong("key", 0)
        }

        val count = "1111".count()
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        mainViewModel.currentName.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                println("backis $t")
            }
        })

    }


//    /**
//     * 生命周期监听 可以在需要的地方添加]
//     */
//    class MyLifecycleObserver:LifecycleObserver{
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
//        fun onCreate() {
//            println("observer ${Lifecycle.Event.ON_CREATE.name}")
//        }
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_START)
//        fun onStart() {
//            println("observer ${Lifecycle.Event.ON_START.name}")
//        }
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//        fun onResume() {
//            println("observer ${Lifecycle.Event.ON_RESUME.name}")
//        }
//
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
//        fun onPause() {
//            println("observer ${Lifecycle.Event.ON_PAUSE.name}")
//        }
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
//        fun onStop() {
//            println("observer ${Lifecycle.Event.ON_STOP.name}")
//        }
//
//        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//        fun onDestory() {
//            println("observer ${Lifecycle.Event.ON_DESTROY.name}")
//        }
//    }

    /**
     * DEFAULT	立即执行协程体
    ATOMIC	立即执行协程体，但在开始运行之前无法取消
    UNDISPATCHED	立即在当前线程执行协程体，直到第一个 suspend 调用
    LAZY	只有在需要的情况下运行
     */
    private fun startCoroutine() {
///////////////////////////////////////////////////////////////////////////////////////////////
        //TODO 谨慎使用 GlobalScope 启动的协程并不会随着 Activity 的销毁而被取消
//        //默认 launch 调用后，会立即进入待调度状态
//        //启动新线程
//        val jobDefault = GlobalScope.launch {
//            //delay 会让协程挂起，这个过程并不会阻塞 CPU
//            for (index in 0..10){//开启10个线程 执行耗时操作
//                val result = async {
//                    delay(2000)
//                    "hello"
//                }
//                println("coroutine GlobalScope result $index ${result.await()}")
//            }
//        }

        //取消 delay 之后代码之后的全部都不执行
//        jobDefault.cancel()

/////////////////////////////////////////////////////////////////////////////////////////////////
//        //调用 Job.start，主动触发协程的调度执行
//        //调用 Job.join，隐式的触发协程的调度执行
//        //启动新线程
//        val jobLazy = GlobalScope.launch(start = CoroutineStart.LAZY) {
//            println("coroutine LAZY 2 ${Thread.currentThread()}")
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////
//        //launch 调用后，会立即进入待调度状态 启动新线程
//        val jobAtomic = GlobalScope.launch(start = CoroutineStart.ATOMIC
//        ) {
//            println("coroutine ATOMIC 3 ${Thread.currentThread()}")
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////
//        //launch 调用后，会立即进入待调度状态 当前线程中调用
//        val jobUnDispatched = GlobalScope.launch(start = CoroutineStart.UNDISPATCHED) {
//            println("coroutine UNDISPATCHED 4 ${Thread.currentThread()}")
//        }
/////////////////////////////////////////////////////////////////////////////////////////////////

        //Android 开发经常想到的一点就是让发出去的请求能够在当前 UI 或者 Activity 退出或者销毁的时候能够自动取消，我们在用 RxJava 的时候也有过各种各样的方案来解决这个问题
        //协程有一个很天然的特性能刚够支持这一点，那就是作用域

        //在 Android 中我们经常使用两类 context:
        //uiContext: 用于执行 UI 相关操作
        //bgContext: 用于执行需要在后台运行的耗时操作

        val mainScop = MainScope().launch {
            for (index in 0..5) {//开启10个线程 执行耗时操作

                //两个 async 顺序执行

                val result1 = async {
                    delay(1000)
                    "hello1"
                }

                println("coroutine MainScope result $index ${result1.await()}")

                val result2 = async {
                    delay(3000)
                    "hello2"
                }

                println("coroutine MainScope result $index ${result2.await()}")

            }
        }


    }

}
