package com.wiseowl.masterji.core.domain.logger

import android.util.Log

class LogcatLogger: Logger {
    override fun v(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun d(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun i(tag: String, message: String) {
        Log.i(tag, message)
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        if(throwable!=null) Log.w(tag, message)
        else Log.w(tag, message)
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        if(throwable!=null) Log.e(tag, message)
        else Log.e(tag, message)
    }
}