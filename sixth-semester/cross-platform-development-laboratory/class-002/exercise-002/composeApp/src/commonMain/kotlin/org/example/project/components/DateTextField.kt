package org.example.project.components

import androidx.compose.material.Text
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable

@Composable
fun DateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "Data de nascimento"
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            val cleaned = it.filter { c -> c.isDigit() }
            val formatted = buildString {
                for (i in cleaned.indices) {
                    append(cleaned[i])
                    if (i == 1 || i == 3) append('/')
                }
            }.take(10)
            onValueChange(formatted)
        },
        label = { Text(label) }
    )
}
