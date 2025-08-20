package com.wiseowl.masterji.core.domain.algorithm

import androidx.annotation.CallSuper


abstract class Program(
    open val onStepComplete: (stepNumber: Int) -> Unit = { _ -> },
){
    protected var stepNumber: Int = 0
    abstract fun next()

    abstract fun onStep()
}

class BubbleSort(
    list: List<Int>,
    override val onStepComplete: (Int) -> Unit,
    val onSwap: (Int, Int) -> Unit,
    val onProgramComplete: () -> Unit
): Program(onStepComplete){
    val mList = list.toMutableList()
    var i: Int = 0
    var j: Int = 0

    override fun next(){
        val n = mList.size
        if(i < n - 1) {
            if (j < n - 1) {
                if (mList[j] > mList[j + 1]) {
                    // Swap elements
                    val temp = mList[j]
                    mList[j] = mList[j + 1]
                    mList[j + 1] = temp
                    onSwap(j, j + 1)
                }
                onStep()
                j++
            } else{
                j=0
                i++
            }
        }else{
            onProgramComplete()
        }
    }

    override fun onStep() {
        onStepComplete(stepNumber++)
    }
}