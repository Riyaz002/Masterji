package com.wiseowl.masterji.feature_home.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

@Composable
fun SectionCard(
    title: String,
    subtitle: String,
    backgroundBrush: Brush
) {
    Column(
        Modifier.fillMaxWidth().background(backgroundBrush)
    ) {
        Row {
            Text(
                title,
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Forward Arrow",
                tint = Color.Black
            )
        }

        Text(
            subtitle,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}