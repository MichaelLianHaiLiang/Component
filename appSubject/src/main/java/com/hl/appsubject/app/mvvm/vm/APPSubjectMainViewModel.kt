package com.hl.appsubject.app.mvvm.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * @Author: maijie20180425
 * Time: 2019/9/10
 * Description:
 */
class APPSubjectMainViewModel(application: Application) : AndroidViewModel(application) {

    val lastName = MutableLiveData("This is AppSubject")
}