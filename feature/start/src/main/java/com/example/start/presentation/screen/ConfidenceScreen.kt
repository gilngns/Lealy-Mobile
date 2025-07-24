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
import androidx.navigation.compose.rememberNavController
import com.example.start.presentation.StartViewModel
import com.example.start.presentation.component.TopProgressBar
import com.example.start.presentation.theme.Poppins
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

@Composable
fun ConfidenceScreen(
    navController: NavHostController,
    viewModel: StartViewModel,
    initialSelectedOption: String? = null
) {
    var selectedOption by rememberSaveable { mutableStateOf<String?>(null) }

    val options = listOf(
        "Tidak yakin sama sekali",
        "Yakin untuk soal dasar",
        "Yakin sampai soal menengah",
        "Yakin untuk soal lanjutan"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp), // Sisakan ruang untuk tombol
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                TopProgressBar(progress = 1.0f)
                Spacer(modifier = Modifier.height(1.dp))

                Text(
                    text = "● Tingkat Kepercayaan Diri",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF0057FF),
                    fontFamily = Poppins,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Seberapa yakin\nAnda bisa menjawab\nkuis tentang investasi?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 28.sp,
                    fontFamily = Poppins,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))
            }

            items(options) { option ->
                val isSelected = selectedOption == option
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 72.dp)
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
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 16.dp),
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
        }

        // Tombol tetap di bawah
        Button(
            onClick = {
                selectedOption?.let {
                    viewModel.setConfidenceAnswer(it)
                    navController.navigate(StartRoute.Result.route)
                }
            },
            enabled = selectedOption != null,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(bottom = 32.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0057FF),
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Selesai",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun ConfidenceScreenPreview() {
    val dummyNavController = rememberNavController()
    val dummyViewModel = StartViewModel()

    ConfidenceScreen(
        navController = dummyNavController,
        viewModel = dummyViewModel,
        initialSelectedOption = "Yakin untuk soal dasar"
    )
}
