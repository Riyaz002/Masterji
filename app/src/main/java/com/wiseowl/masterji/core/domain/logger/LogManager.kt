package com.wiseowl.masterji.core.domain.logger

import kotlin.reflect.KClass

class LogManager: Logger {
    private var loggers = hashMapOf<KClass<out Logger> ,Logger>()

    fun add(logger: Logger): LogManager{
        loggers.put(logger::class,logger)
        return this
    }

    override fun v(tag: String, message: String) {
        loggers.forEach { v(tag, message) }
    }

    override fun d(tag: String, message: String) {
        loggers.forEach { d(tag, message) }
    }

    override fun i(tag: String, message: String) {
        loggers.forEach { i(tag, message) }
    }

    override fun w(tag: String, message: String, throwable: Throwable?) {
        loggers.forEach { w(tag, message, throwable) }
    }

    override fun e(tag: String, message: String, throwable: Throwable?) {
        loggers.forEach { e(tag, message, throwable) }
    }


}