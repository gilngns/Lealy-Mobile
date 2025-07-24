package com.example.start.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.start.presentation.component.TopProgressBar
import com.example.start.presentation.theme.Poppins

@Composable
fun ExperienceScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    val options = listOf(
        "Belum pernah sama sekali",
        "Sudah pernah di Reksadana/\nObligasi/Saham (Satu instrumen)",
        "Sudah lebih dari 1 instrumen"
    )

    var selectedOption by rememberSaveable { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TopProgressBar(progress = 0.48f)
        Spacer(modifier = Modifier.height(1.dp))

        Text(
            text = "● Pengalaman Investasi",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF0057FF),
            fontFamily = Poppins,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Apakah Anda sudah\npernah berinvestasi\nsecara nyata?",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = Poppins,
            lineHeight = 28.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        options.forEach { option ->
            val isSelected = selectedOption == option
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(72.dp) // Tinggi disamakan
                    .padding(vertical = 6.dp)
                    .clickable { selectedOption = option },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    1.dp,
                    if (isSelected) Color(0xFF0057FF) else Color(0xFFE0E0E0)
                ),
                color = if (isSelected) Color(0xFFDCEBFF) else Color(0xFFF5F5F5)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = option,
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF212121),
                        maxLines = 2
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onBack,
                border = BorderStroke(1.dp, Color(0xFF0057FF)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text("Kembali", color = Color(0xFF0057FF), fontFamily = Poppins)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = onNext,
                enabled = selectedOption != null,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0057FF),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text("Lanjut", fontFamily = Poppins)
            }
        }
    }
}

@Composable
fun ExperienceScreen(navController: NavHostController) {
    ExperienceScreen(
        onBack = { navController.popBackStack() },
        onNext = { navController.navigate(StartRoute.Topics.route) }
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun ExperienceScreenPreview() {
    ExperienceScreen()
}
