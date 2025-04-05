package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.screens.TutorScreen
import org.example.project.screens.PetScreen
import androidx.compose.foundation.layout.Spacer

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("tutor") }

    Column {
        Row {
            Button(onClick = { currentScreen = "tutor" }) { Text("Tutores") }
            Button(onClick = { currentScreen = "pet" }) { Text("Pets") }
        }
        
        when (currentScreen) {
            "tutor" -> TutorScreen()
            "pet" -> PetScreen()
        }
    }
}
