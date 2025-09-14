package com.wiseowl.masterji.core.domain.logger

import com.google.firebase.crashlytics.FirebaseCrashlytics

class CrashlyticsLogger: Logger {
    val crashlyticsInstance = FirebaseCrashlytics.getInstance()
    override fun v(tag: String, message: String) {
        crashlyticsInstance.log("Verbose [$tag]: $message")
    }

    override fun d(tag: String, message: String) {
        crashlyticsInstance.log("Debug [$tag]: $message")
    }

    override fun i(tag: String, message: String) {
        crashlyticsInstance.log("Info [$tag]: $message")
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        crashlyticsInstance.log("Warning [$tag]: $message")
        throwable?.let { crashlyticsInstance.recordException(it) }
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        crashlyticsInstance.log("Error [$tag]: $message")
        throwable?.let { crashlyticsInstance.recordException(it) }
    }
}