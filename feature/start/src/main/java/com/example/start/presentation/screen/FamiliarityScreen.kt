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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.start.presentation.component.TopProgressBar
import com.example.start.presentation.theme.Poppins

@Composable
fun FamiliarityScreen(
    onNext: () -> Unit = {}
) {
    var selectedOption by rememberSaveable { mutableStateOf<String?>(null) }

    val options = listOf(
        "Belum pernah sama sekali",
        "Pernah, tapi hanya sekilas",
        "Sudah cukup tahu"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        // Konten utama di atas
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopProgressBar(progress = 0.16f)
            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "● Pengetahuan Awal",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0057FF),
                fontFamily = Poppins,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Seberapa familiar\nAnda dengan dunia investasi?",
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
                        .height(64.dp) // tinggi seragam
                        .padding(vertical = 6.dp)
                        .clickable { selectedOption = option },
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(
                        1.dp,
                        if (isSelected) Color(0xFF0057FF) else Color(0xFFE0E0E0)
                    ),
                    color = if (isSelected) Color(0xFFE3F2FD) else Color(0xFFF5F5F5)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = option,
                            fontSize = 14.sp,
                            fontFamily = Poppins,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF212121),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }

        // Tombol lanjut di bagian bawah layar
        Button(
            onClick = { selectedOption?.let { onNext() } },
            enabled = selectedOption != null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .height(48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0057FF),
                contentColor = Color.White
            )
        ) {
            Text("Lanjut", fontFamily = Poppins)
        }
    }
}


@Composable
fun FamiliarityScreen(navController: NavHostController) {
    FamiliarityScreen {
        navController.navigate(StartRoute.Instruments.route)
    }
}

@Preview(
    showBackground = true,
    device = Devices.NEXUS_5
)
@Composable
fun FamiliarityScreenPreview() {
    FamiliarityScreen()
}
