package com.wiseowl.masterji.core.ui.components.animation.model

import androidx.annotation.IntRange

enum class AnimationSpeed(@IntRange(from = 1, to = 5) val speed: Int) {
    ONE_X(1),
    TWO_X(2),
    THREE_X(3),
    FOUR_X(4),
    FIVE_X(5),
}