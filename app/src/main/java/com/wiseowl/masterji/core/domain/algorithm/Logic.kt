package com.wiseowl.masterji.core.domain.algorithm



abstract class Logic(
    open val onStepComplete: (stepNumber: Int) -> Unit = { _ -> },
){
    protected var stepNumber: Int = 0
    abstract fun next()
}

sealed class SortLogic(
    val list: List<Int>,
): Logic(){

    protected val mList = list.toMutableList()
    protected var i: Int = 0
    protected var j: Int = 0
    protected var mListener: SortLogicListener? = null

    fun getList(): List<Int> = mList

    fun setListener(listener: SortLogicListener){ mListener = listener }

    interface SortLogicListener{
        fun onStepComplete(stepNumber: Int) = Unit
        fun onSwap(i: Int, j: Int) = Unit
        fun onProgramFinish() = Unit
    }

    class BubbleSort(
        list: List<Int>,
    ): SortLogic(list){
        override fun next(){
            val n = mList.size
            if(i < n - 1) {
                if (j < n - 1) {
                    if (mList[j] > mList[j + 1]) {
                        // Swap elements
                        val temp = mList[j]
                        mList[j] = mList[j + 1]
                        mList[j + 1] = temp
                        mListener?.onSwap(j, j + 1)
                    }
                    mListener?.onStepComplete(stepNumber++)
                    j++
                } else{
                    j=0
                    i++
                }
            }else{
                mListener?.onProgramFinish()
            }
        }
    }
}

