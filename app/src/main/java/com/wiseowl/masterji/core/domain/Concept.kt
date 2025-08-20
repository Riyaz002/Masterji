package com.wiseowl.masterji.core.domain

sealed class Concept
data class DataStructure(val name: String, val description: String, val lesson: Lesson): Concept()
data class Algorithm(val name: String, val description: String, val lesson: Lesson): Concept()