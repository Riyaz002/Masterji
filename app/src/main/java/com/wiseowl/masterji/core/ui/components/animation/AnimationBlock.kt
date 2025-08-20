package com.wiseowl.masterji.core.ui.components.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wiseowl.masterji.core.ui.components.animation.model.AnimationConfiguration


@Composable
fun AnimationBlock(
    modifier: Modifier = Modifier,
    inputEditor: (@Composable () -> Unit)? = null,
    animation: @Composable (AnimationConfiguration) -> Unit
) {
    var animationConfiguration by remember(Unit) {
        mutableStateOf(AnimationConfiguration(isRunning = false, hasBreaker = false))
    }

    Column(modifier) {
        animation(animationConfiguration)
        AnimationConfigurationInput(onConfigurationChange = { animationConfiguration = it})
        Spacer(Modifier.height(10.dp))
        inputEditor?.invoke()
    }
}
