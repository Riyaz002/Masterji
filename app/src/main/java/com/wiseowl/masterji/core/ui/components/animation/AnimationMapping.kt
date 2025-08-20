package com.wiseowl.masterji.core.ui.components.animation

import androidx.compose.runtime.Composable
import com.wiseowl.masterji.core.domain.AnimationType
import com.wiseowl.masterji.core.domain.Sort
import com.wiseowl.masterji.core.ui.components.animation.sort.BubbleSort

val animationRegistry: Map<AnimationType, @Composable () -> Unit> = mapOf(
    Sort.BubbleSort to { BubbleSort() }
)