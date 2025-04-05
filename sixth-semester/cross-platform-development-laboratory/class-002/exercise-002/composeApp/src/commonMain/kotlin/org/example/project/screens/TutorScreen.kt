package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TutorScreen() {
    MaterialTheme {
        Column( modifier = mainColumnStyle.modifier ) {
            Header("Tutores")
            Spacer(modifier = Modifier.height(16.dp))
            TutorForm()
            Spacer(modifier = Modifier.height(16.dp))
            TutorList()
        }
    }
}
