package com.wiseowl.masterji.core.ui.components.animation.sort

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import kotlin.math.min

@Composable
fun InputEditor(
    modifier: Modifier = Modifier,
    currentInput: List<Int>,
    onInputChanged: (List<Int>) -> Unit
) {

    TextField(
        modifier = modifier,
        value = currentInput.toString().removePrefix("[").removeSuffix("]"),
        onValueChange = {
            runCatching {
                val newInput = it.split(",").map { min(it.trim().toInt(), 100) }
                onInputChanged(newInput)
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )
}