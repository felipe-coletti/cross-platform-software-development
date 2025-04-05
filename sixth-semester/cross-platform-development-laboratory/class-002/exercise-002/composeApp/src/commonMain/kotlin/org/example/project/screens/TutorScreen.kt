package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.styles.mainColumnStyle
import org.example.project.components.Header
import org.example.project.components.TutorForm
import org.example.project.components.TutorList
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
