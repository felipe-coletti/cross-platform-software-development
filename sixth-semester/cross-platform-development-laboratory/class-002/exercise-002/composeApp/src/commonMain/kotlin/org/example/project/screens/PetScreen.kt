package org.example.project.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import org.example.project.styles.screenColumnStyle
import org.example.project.styles.screenContentColumnStyle
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.components.Header
import org.example.project.components.PetForm
import org.example.project.components.PetList
import org.example.project.viewmodel.PetViewModel
import androidx.compose.runtime.remember

@Composable
fun PetScreen() {
    val viewModel = remember { PetViewModel() }

    Column(modifier = screenColumnStyle.modifier) {
        Header("Pets")
        Column(
            modifier = screenContentColumnStyle.modifier,
            verticalArrangement = screenColumnStyle.verticalArrangement
        ) {
            PetForm(viewModel)
            PetList(viewModel.pets)
        }
    }
}
