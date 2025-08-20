package com.wiseowl.masterji.core.domain.algorithm

interface AnimationType

sealed interface Sort: AnimationType{
    object BubbleSort: Sort
    object MergeSort: Sort
    object MedianSort: Sort
}