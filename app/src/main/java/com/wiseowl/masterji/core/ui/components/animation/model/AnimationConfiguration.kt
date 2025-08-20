package com.wiseowl.masterji.core.ui.components.animation.model

data class AnimationConfiguration(
    val isRunning: Boolean,
    val speed: AnimationSpeed = AnimationSpeed.ONE_X,
    val hasBreaker: Boolean = false
)


