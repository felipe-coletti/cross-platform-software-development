package org.example.project

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.screens.PetScreen
import org.example.project.screens.TutorScreen

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Button(onClick = { currentScreen = "pet" }) {
                Text("Ir para Pets")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { currentScreen = "tutor" }) {
                Text("Ir para Tutores")
            }
        }

        "pet" -> PetScreen()
        "tutor" -> TutorScreen()
    }
}

