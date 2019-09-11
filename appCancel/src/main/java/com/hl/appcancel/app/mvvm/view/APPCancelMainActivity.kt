package com.hl.appcancel.app.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hl.appcancel.R
import com.hl.appcancel.app.mvvm.vm.APPCancelMainViewModel
import com.hl.appcancel.databinding.ActivityMainBinding

/**
 * @Author: maijie20180425
 * Time: 2019/9/10
 * Description:
 */
class APPCancelMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO databinding
        //TODO 第一步 Obtain ViewModel from ViewModelProviders
        val mainViewModel = ViewModelProvider(this).get(APPCancelMainViewModel::class.java)
//        val mainViewModel = ViewModelProviders.of(this).get(APPCancelMainViewModel::class.java) //过时方法

        // Obtain binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Bind layout with ViewModel
        binding.viewmodel = mainViewModel

        // LiveData needs the lifecycle owner
        binding.lifecycleOwner = this
    }
}