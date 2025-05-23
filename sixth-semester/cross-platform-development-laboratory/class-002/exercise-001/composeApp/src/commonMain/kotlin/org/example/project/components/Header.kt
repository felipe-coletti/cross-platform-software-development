package org.example.project.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.project.styles.headerColumnStyle

@Composable
fun Header() {
    Column(
        modifier = headerColumnStyle.modifier,
        horizontalAlignment = headerColumnStyle.horizontalAlignment
    ) {
        Text("Contatos")
    }
}