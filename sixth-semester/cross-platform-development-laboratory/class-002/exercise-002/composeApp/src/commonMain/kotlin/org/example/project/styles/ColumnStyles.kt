package org.example.project.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ColumnStyle(
    val modifier: Modifier,
    val horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    val verticalArrangement: Arrangement.Vertical = Arrangement.Top
)

val screenColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
)

val screenContentColumnStyle = ColumnStyle(
    modifier = Modifier
        .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)
)

val headerColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.Blue)
        .padding(vertical = 16.dp),
    horizontalAlignment = Alignment.CenterHorizontally
)

val formColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(8.dp)
)

val listColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
)

val cardColumnStyle = ColumnStyle(
    modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
    verticalArrangement = Arrangement.spacedBy(4.dp)
)

