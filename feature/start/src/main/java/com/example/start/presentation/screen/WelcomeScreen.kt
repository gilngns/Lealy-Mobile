package com.example.start.presentation.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.start.R
import com.example.start.presentation.theme.Poppins

@Composable
fun WelcomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        // Konten di tengah
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            // Logo dan Judul
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Lealy Logo",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "Lealy",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF0F1441),
                    fontFamily = Poppins
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Selamat Datang!",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontFamily = Poppins,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Mari mulai perjalanan investasi Anda dengan assessment singkat untuk mengetahui level pengetahuan Anda.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                lineHeight = 20.sp,
                textAlign = TextAlign.Start,
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(1.dp, Color(0xFF0057FF)),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp)
            ) {
                Text(
                    "Yang akan Anda dapatkan:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = Poppins
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("• Level pengetahuan personal", fontSize = 13.sp, fontFamily = Poppins)
                Text("• Jalur belajar yang tepat", fontSize = 13.sp, fontFamily = Poppins)
                Text("• Rekomendasi materi investasi", fontSize = 13.sp, fontFamily = Poppins)
            }
        }

        // Tombol tetap di bawah
        Button(
            onClick = { navController.navigate(StartRoute.Familiarity.route) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
                .align(Alignment.BottomCenter),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0057FF),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                "Mulai",
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(navController = rememberNavController())
}