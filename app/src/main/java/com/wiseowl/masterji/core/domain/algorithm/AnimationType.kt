package com.wiseowl.masterji.core.domain.algorithm

interface AnimationType

sealed interface Sort: AnimationType{
    object BubbleSort: SortLogic
    object MergeSort: SortLogic
    object MedianSort: SortLogic
}