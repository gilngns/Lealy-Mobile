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
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.start.presentation.component.TopProgressBar
import com.example.start.presentation.theme.Poppins

@Composable
fun TopicInterestScreen(
    onBack: () -> Unit = {},
    onNext: () -> Unit = {}
) {
    val options = listOf(
        "Dasar-dasar investasi & pengelolaan risiko",
        "Cara kerja & simulasi instrumen investasi",
        "Analisa teknikal & strategi investasi lanjutan"
    )

    var selectedOptions by rememberSaveable { mutableStateOf<List<String>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TopProgressBar(progress = 0.64f)
        Spacer(modifier = Modifier.height(1.dp))

        Text(
            text = "● Topik Minat",
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF0057FF),
            fontFamily = Poppins,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Topik mana yang\npaling ingin Anda\npelajari?",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 28.sp,
            fontFamily = Poppins,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        options.forEach { option ->
            val isSelected = selectedOptions.contains(option)
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 72.dp)
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
                        .fillMaxWidth()
                        .padding(vertical = 16.dp, horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = option,
                        fontSize = 15.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF212121)
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
fun TopicInterestScreen(navController: NavHostController) {
    TopicInterestScreen(
        onBack = { navController.popBackStack() },
        onNext = { navController.navigate(StartRoute.Confidence.route) }
    )
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun TopicInterestScreenPreview() {
    TopicInterestScreen()
}
