package org.example.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.ui.unit.dp

data class ColumnStyle(
    val modifier: Modifier,
    val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    val verticalArrangement: Arrangement.Vertical = Arrangement.Top
)

val mainColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFE0F7FA))
        .padding(16.dp)
)

val headerColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFFFF176))
        .padding(vertical = 16.dp)
    horizontalAlignment = Alignment.CenterHorizontally
)

val formColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .padding(16.dp)
)

val listColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color(0xFFE3F2FD))
        .padding(16.dp)
)

