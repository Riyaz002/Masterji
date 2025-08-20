package com.wiseowl.masterji.core.ui.components.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.wiseowl.masterji.core.ui.components.animation.model.AnimationConfiguration


@Composable
fun AnimationScope(
    modifier: Modifier = Modifier,
    animation: @Composable (AnimationConfiguration) -> Unit
) {
    val animationConfiguration by remember(Unit) {
        mutableStateOf(AnimationConfiguration(isRunning = false, hasBreaker = false))
    }

    Column(modifier) {
        animation(animationConfiguration)
        AnimationConfigurationInput()
    }
}
