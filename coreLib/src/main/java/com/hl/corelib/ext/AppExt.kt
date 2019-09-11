package com.hl.corelib.ext

import android.app.Application
import com.hl.corelib.CoreApplication

fun getApplicaiton(): Application {
    return CoreApplication.INSTANCE
}