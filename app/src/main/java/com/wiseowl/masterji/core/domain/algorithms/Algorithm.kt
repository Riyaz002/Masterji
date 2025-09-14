package com.wiseowl.masterji.core.domain.algorithms


abstract class Algorithm{

    private var mFinished: Boolean = false
    fun isFinished(): Boolean = mFinished
    protected fun onFinished(){ mFinished = true }

    protected var stepNumber: Int = 0
    private var mStepListener: ((stepNumber: Int) -> Unit)? = null
    fun setOnStepListener(listener: (stepNumber: Int) -> Unit){ mStepListener = listener }
    protected fun onStep(){ (++stepNumber).let { mStepListener?.invoke(it) } }

    abstract fun next()
}



