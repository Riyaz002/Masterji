package com.wiseowl.masterji.core.domain.algorithms.sort

import com.wiseowl.masterji.core.domain.algorithms.Algorithm

abstract class Sort(
    list: List<Int>,
): Algorithm(){
    protected val mList = list.toMutableList()

    fun getUpdatedList(): List<Int> = mList
}