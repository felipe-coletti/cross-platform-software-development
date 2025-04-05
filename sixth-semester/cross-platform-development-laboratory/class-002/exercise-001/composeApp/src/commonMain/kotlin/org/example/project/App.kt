package org.example.project

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column( modifier = mainColumnStyle.modifier ) {
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            Form()
            Spacer(modifier = Modifier.height(16.dp))
            ContactList()
        }
    }
}
