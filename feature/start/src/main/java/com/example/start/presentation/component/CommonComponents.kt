package com.example.start.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SingleChoiceQuestion(
    title: String,
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit,
    onNextClicked: () -> Unit,
    nextButtonText: String = "Mulai"
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        options.forEach { option ->
            OutlinedButton(
                onClick = { onOptionSelected(option) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (option == selectedOption)
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    else MaterialTheme.colorScheme.surface
                )
            ) {
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNextClicked,
            enabled = selectedOption != null,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(nextButtonText)
        }
    }
}

@Composable
fun MultiChoiceQuestion(
    title: String,
    options: List<String>,
    selectedOptions: List<String>,
    onOptionToggled: (String) -> Unit,
    onNextClicked: () -> Unit,
    nextButtonText: String = "Mulai"
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        options.forEach { option ->
            val selected = selectedOptions.contains(option)
            OutlinedButton(
                onClick = { onOptionToggled(option) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = if (selected)
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                    else MaterialTheme.colorScheme.surface
                )
            ) {
                Text(option)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onNextClicked,
            enabled = selectedOptions.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(nextButtonText)
        }
    }
}


@Composable
fun TopProgressBar(progress: Float) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(
            progress = progress,
            color = Color(0xFF0057FF),
            trackColor = Color(0xFFE0E0E0),
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}
