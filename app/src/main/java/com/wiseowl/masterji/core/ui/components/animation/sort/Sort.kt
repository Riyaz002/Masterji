package com.wiseowl.masterji.core.ui.components.animation.sort

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiseowl.masterji.core.domain.algorithm.SortLogic
import com.wiseowl.masterji.core.ui.components.animation.AnimationBlock

@Preview
@Composable
fun BubbleSort(
    modifier: Modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.onBackground),
) {
    var input by remember { mutableStateOf(listOf(50, 20, 211, 70, 10, 70, 10, 70, 10, 70, 10)) }
    AnimationBlock(
        modifier,
        inputEditor = { InputEditor(
            modifier = Modifier.fillMaxWidth(),
            currentInput = input, onInputChanged = { input = it }
        ) }
    ) {
        BubbleSort(SortLogic.BubbleSort(input))
    }
}



@Composable
fun BubbleSort(
    program: SortLogic
) {

    val input = listOf<Int>()
    program.next()
    program.setListener(
        object : SortLogic.SortLogicListener{
            override fun onStepComplete(stepNumber: Int) = Unit
        }
    )

    val width = remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .onSizeChanged{
                with(density){
                    val newWidth = it.width.toDp()/input.size
                    if(width.value != newWidth){
                        width.value = newWidth
                    }
                }
            },
        verticalAlignment = Alignment.Bottom
    ) {
        items(items = input, key = { it }){
            Bar(Modifier
                .height(input.get(it)!!.dp)
                .width(width.value)
                .padding(horizontal = 1.dp)
                .padding(top = 2.dp)
                .animateItem(
                    fadeInSpec = tween(3000),   // control enter animation
                    fadeOutSpec = tween(3000),  // control exit animation
                )
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            )
        }
    }
}