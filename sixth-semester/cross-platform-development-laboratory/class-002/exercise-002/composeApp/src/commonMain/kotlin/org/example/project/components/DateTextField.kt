import org.example.project.utils.inputMasks.applyDateMask

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier

@Composable
fun DateTextField(dateState: MutableState<String>) {
    TextField(
        value = dateState.value,
        onValueChange = { newValue ->
            dateState.value = applyDateMask(newValue)
        },
        label = { Text("Data de Nascimento") },
        placeholder = { Text("DD/MM/AAAA") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}
