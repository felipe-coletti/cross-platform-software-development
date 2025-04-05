package org.example.project.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.example.project.styles.screenColumnStyle
import org.example.project.styles.screenContentColumnStyle
import org.example.project.components.Header
import org.example.project.components.TutorForm
import org.example.project.components.TutorList
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.viewmodel.TutorViewModel
import androidx.compose.runtime.remember

@Composable
fun TutorScreen() {
    val viewModel = remember { TutorViewModel() }

    Column(modifier = screenColumnStyle.modifier) {
        Header("Tutores")
        Column(
            modifier = screenContentColumnStyle.modifier,
            verticalArrangement = screenColumnStyle.verticalArrangement
        ) {
            TutorForm(viewModel)
            TutorList(viewModel.tutors)
        }
    }
}
