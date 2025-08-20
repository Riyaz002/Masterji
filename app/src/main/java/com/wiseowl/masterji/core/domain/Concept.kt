package com.wiseowl.masterji.core.domain

sealed class Concept
data class DataStructure(val name: String, val description: String, val lesson: Lesson): Concept()
data class Algorithm(val name: String, val description: String, val lesson: Lesson): Concept()

class BubbleSort(): Algorithm(
    "Bubble Sort",
    "A simple algorithm that repeatedly swaps adjacent elements if they are in the wrong order.",
    Lesson(listOf(
        LessonBlock.Heading("Bubble Sort", 1),
        LessonBlock.Paragraph("Bubble Sort is a simple algorithm that repeatedly swaps adjacent elements if they are in the wrong order."),
        LessonBlock.Animation(

        )
    ))
)