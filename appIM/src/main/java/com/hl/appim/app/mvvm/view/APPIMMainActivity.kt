package com.hl.appim.app.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hl.appim.R
import com.hl.appim.app.mvvm.vm.APPIMMainViewModel
import com.hl.appim.databinding.ActivityMainBinding

/**
 * @Author: maijie20180425
 * Time: 2019/9/10
 * Description:
 */
class APPIMMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO databinding
        //TODO 第一步 Obtain ViewModel from ViewModelProviders
        val mainViewModel = ViewModelProvider(this).get(APPIMMainViewModel::class.java)
//        val mainViewModel = ViewModelProviders.of(this).get(APPIMMainViewModel::class.java) //过时方法

        // Obtain binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind layout with ViewModel
        binding.viewmodel = mainViewModel

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
    }
}