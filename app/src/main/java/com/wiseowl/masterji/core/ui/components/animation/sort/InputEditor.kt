package com.wiseowl.masterji.core.ui.components.animation.sort

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun InputEditor(
    modifier: Modifier = Modifier,
    currentInput: List<Int>,
    onInputChanged: (List<Int>) -> Unit
) {

    TextField(
        modifier = modifier,
        value = currentInput.toString(),
        onValueChange = {
            val newInput = it.split(",").map { it.trim().toInt() }
            onInputChanged(newInput)
        }
    )
}