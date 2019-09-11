package com.hl.myapp

import com.hl.componentlogin.LoginObserver
import com.hl.corelib.CoreApplication

class AppApplication : CoreApplication() {

    //TODO 初始化相关资源
    override fun onCreate() {
        super.onCreate()

        //注册全局登陆监听 回调成功状态 然后读取配置信息 配置基本工程
//        val loginSuccess = LoginType.LOGIN_SUCCESS
//        println("loginSuccess is $loginSuccess")

        LoginObserver.loginResult.observeForever {
            if (it == 1) {//登录成功
                if (BuildConfig.IS_NEED_APP_CANCEL.toBoolean()) {
                    //初始化appCancel模块内容
                }

                if (BuildConfig.IS_NEED_APP_IM.toBoolean()) {
                    //初始化appIM模块内容
                }

                if (BuildConfig.IS_NEED_APP_SITE.toBoolean()) {
                    //初始化appSite模块内容
                }

                if (BuildConfig.IS_NEED_APP_SUBJECT.toBoolean()) {
                    //初始化appSubject模块内容
                }
            } else {
                //登录失败
            }
        }
    }

}