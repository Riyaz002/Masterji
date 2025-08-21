package com.wiseowl.masterji.core.domain.algorithm


abstract class Logic{

    private var mFinished: Boolean = false
    fun isFinished(): Boolean = mFinished
    protected fun onFinished(){ mFinished = true }

    protected var stepNumber: Int = 0
    private var mStepListener: ((stepNumber: Int) -> Unit)? = null
    fun setOnStepListener(listener: (stepNumber: Int) -> Unit){ mStepListener = listener }
    protected fun onStep(){ mStepListener?.invoke(stepNumber++) }

    abstract fun next()
}

sealed class SortLogic(
    list: List<Int>,
): Logic(){
    protected val mList = list.toMutableList()

    fun getUpdatedList(): List<Int> = mList

    class BubbleSort(
        list: List<Int>,
    ): SortLogic(list){
        private var _i: Int = 0
        val i: Int get() = _i
        private var _j: Int = 0
        val j: Int get() = _j
        private var mSwapListener: ((i: Int, j: Int) -> Unit)? = null


        fun setOnSwapListener(listener: (i: Int, j: Int) -> Unit){
            mSwapListener = listener
        }

        override fun next(){
            if(!isFinished()){
                val n = mList.size
                if(i < n - 1) {
                    if (j < n - 1) {
                        if (mList[j] > mList[j + 1]) {
                            // Swap elements
                            val temp = mList[j]
                            mList[j] = mList[j + 1]
                            mList[j + 1] = temp
                            mSwapListener?.invoke(j, j + 1)
                        }
                        _j++
                    } else{
                        _j=0
                        _i++
                    }
                    onStep()
                } else onFinished()
            }
        }
    }
}

