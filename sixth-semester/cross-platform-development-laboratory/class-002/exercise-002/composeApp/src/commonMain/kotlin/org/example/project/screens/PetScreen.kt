package org.example.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.components.PetForm
import org.example.project.components.PetList
import org.example.project.viewmodel.PetViewModel
import androidx.compose.runtime.remember

@Composable
fun PetScreen() {
    val viewModel = remember { PetViewModel() }

    Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            PetForm(viewModel)
            PetList(viewModel.pets)
        }
    }
}
