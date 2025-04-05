package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PetScreen() {
    MaterialTheme {
        Column( modifier = mainColumnStyle.modifier ) {
            Header("Pets")
            Spacer(modifier = Modifier.height(16.dp))
            PetForm()
            Spacer(modifier = Modifier.height(16.dp))
            PetList()
        }
    }
}
