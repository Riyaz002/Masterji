package com.wiseowl.masterji.core.ui.components.animation

import androidx.compose.runtime.Composable
import com.wiseowl.masterji.core.domain.algorithm.AnimationType
import com.wiseowl.masterji.core.domain.algorithm.SortLogic
import com.wiseowl.masterji.core.ui.components.animation.sort.BubbleSort

val animationRegistry: Map<AnimationType, @Composable () -> Unit> = mapOf(
    SortLogic.BubbleSort to { BubbleSort() }
)