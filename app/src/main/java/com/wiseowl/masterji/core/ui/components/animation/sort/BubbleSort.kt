package com.wiseowl.masterji.core.ui.components.animation.sort

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wiseowl.masterji.core.ui.components.animation.AnimationScope

@Composable
fun BubbleSort(
    modifier: Modifier = Modifier,
) {
    var input by remember { mutableStateOf(listOf(5, 3, 8, 1, 2)) }
    AnimationScope(modifier) {
        BubbleSortRepresentation(input)
        InputEditor(currentInput = input, onInputChanged = { input = it })
    }
}

@Composable
fun BubbleSortRepresentation(
    input: List<Int>
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(input.size) {
            Bar(Modifier.weight(1f).height(input[it].dp).padding(1.dp))
        }
    }
}