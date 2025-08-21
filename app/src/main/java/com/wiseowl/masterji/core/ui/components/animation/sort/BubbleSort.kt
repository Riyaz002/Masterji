package com.wiseowl.masterji.core.ui.components.animation.sort

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wiseowl.masterji.core.domain.algorithm.SortLogic
import com.wiseowl.masterji.core.ui.components.animation.AnimationBlock
import kotlinx.coroutines.delay

@Preview
@Composable
fun BubbleSort(
    modifier: Modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.onBackground),
) {
    var input by remember { mutableStateOf(listOf(50, 20, 211, 70, 10, 70, 10, 70, 10, 70, 10)) }
    val sortLogic = remember { mutableStateOf(SortLogic.BubbleSort(input)) }
    AnimationBlock(
        modifier,
        inputEditor = {
            InputEditor(
                modifier = Modifier.fillMaxWidth(),
                currentInput = input, onInputChanged = { input = it }
            )
        }
    ) {
        BubbleSort(sortLogic.value)
    }
}



@Composable
fun BubbleSort(
    program: SortLogic.BubbleSort,
) {
    var keys by remember(program.getUpdatedList()) {
        mutableStateOf(List(program.getUpdatedList().size) { it.toString() })
    }
    var input by remember { mutableStateOf(program.getUpdatedList()) }

    LaunchedEffect(program) {
        program.setOnSwapListener { i, j ->
            val newKeys = keys.toMutableList()
            val temp = newKeys[i]
            newKeys[i] = newKeys[j]
            newKeys[j] = temp
            keys = newKeys
            keys = newKeys
        }
        while(!program.isFinished()) {
            program.next()
            delay(200)
        }
    }

    program.next()

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
        itemsIndexed(items = input, key = {index, _ -> keys[index] }){ index, it ->

                Bar(
                    Modifier
                        .requiredHeight(it.dp)
                        .width(width.value)
                        .padding(horizontal = 1.dp)
                        .padding(top = 2.dp)
                        .animateItem(
                           fadeInSpec = tween(3000),   // control enter animation
                            fadeOutSpec = tween(3000),  // control exit animation
                        )
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                ){
                    if(keys[index] == program.i.toString() || keys[index] == program.j.toString()){
                        if(keys[index] == program.i.toString()) Text(
                            "i",
                            color = Color.Black, style = MaterialTheme.typography.titleLarge
                        )
                        if(keys[index] == program.j.toString()) Text(
                            "j",
                            color = Color.Black, style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
        }
    }
}