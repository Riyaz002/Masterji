package com.wiseowl.masterji.core.domain

import com.wiseowl.masterji.core.domain.algorithm.AnimationType

// Top-level Lesson
data class Lesson(
    val blocks: List<LessonBlock>
)

// Every lesson block can be of different type
sealed class LessonBlock {
    data class Heading(val text: String, val level: Int = 1) : LessonBlock()
    data class Paragraph(val text: String) : LessonBlock()
    data class CodeSnippet(val language: String, val code: String) : LessonBlock()
    data class Image(val url: String, val description: String? = null) : LessonBlock()
    data class Animation(val type: AnimationType) : LessonBlock()
    data class Quiz(val question: String, val options: List<String>, val answerIndex: Int) : LessonBlock()
}
