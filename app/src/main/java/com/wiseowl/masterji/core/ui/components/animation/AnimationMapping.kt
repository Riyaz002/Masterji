package com.wiseowl.masterji.core.ui.components.animation

import androidx.compose.runtime.Composable
import com.wiseowl.masterji.core.domain.algorithms.AnimationType
import com.wiseowl.masterji.core.ui.components.animation.sort.BubbleSort
import kotlin.to

val animationRegistry: Map<AnimationType, @Composable () -> Unit> = mapOf(
    AnimationType.BubbleSort to { BubbleSort() }
)