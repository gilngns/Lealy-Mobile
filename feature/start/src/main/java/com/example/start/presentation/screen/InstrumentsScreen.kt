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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.start.presentation.component.TopProgressBar
import com.example.start.presentation.theme.Poppins

@Composable
fun InstrumentsScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    val options = listOf("Reksadana", "Obligasi", "Saham")
    var selectedOptions by rememberSaveable { mutableStateOf<List<String>>(emptyList()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopProgressBar(progress = 0.32f)
            Spacer(modifier = Modifier.height(1.dp))

            Text(
                text = "● Instrumen Investasi",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0057FF),
                fontFamily = Poppins,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Instrumen investasi\nmana yang sudah\nAnda ketahui?\n(Pilih semua yang\nAnda tahu)",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins,
                lineHeight = 28.sp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            options.forEach { option ->
                val isSelected = selectedOptions.contains(option)
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp)
                        .padding(vertical = 6.dp)
                        .clickable {
                            selectedOptions = if (isSelected) {
                                selectedOptions - option
                            } else {
                                selectedOptions + option
                            }
                        },
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
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }

        // Tombol bawah
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
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
                enabled = selectedOptions.isNotEmpty(),
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
fun InstrumentsScreen(navController: NavHostController) {
    InstrumentsScreen(
        onBack = { navController.popBackStack() },
        onNext = { navController.navigate(StartRoute.Experience.route) }
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun InstrumentsScreenPreview() {
    InstrumentsScreen()
}
