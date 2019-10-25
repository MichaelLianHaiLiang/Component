package com.hl.myapp

import com.hl.corelib.CoreApplication

class AppApplication : CoreApplication() {

    override fun onCreate() {
        super.onCreate()

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
    }

}