package com.hl.componentlogin.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hl.componentlogin.R
import com.hl.componentlogin.databinding.SplashActivityMainLayoutBinding
import com.hl.componentlogin.mvvm.vm.SplashMainViewModel

/**
 * 提供一个入口 登录相关操作在此module中完成
 */
class SplashMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainViewModel = ViewModelProvider(this).get(SplashMainViewModel::class.java)
        //使得ViewModel获取到Activity的生命周期
        lifecycle.addObserver(mainViewModel)
        val binding: SplashActivityMainLayoutBinding =
            DataBindingUtil.setContentView(this, R.layout.splash_activity_main_layout)
        binding.viewmodel = mainViewModel
        binding.lifecycleOwner = this
    }

}
