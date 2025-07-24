    package com.example.start.presentation.screen

    import androidx.compose.foundation.BorderStroke
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.MenuBook
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
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
    import androidx.navigation.NavHostController
    import com.example.start.R
    import com.example.start.presentation.StartViewModel
    import com.example.start.presentation.component.TopProgressBar
    import com.example.start.presentation.theme.Poppins

    @Composable
    fun ResultScreen(
        navController: NavHostController? = null,
        viewModel: StartViewModel
    ) {
        val level = viewModel.getLevelFromAnswer()
        val recommendation = viewModel.getRecommendationFromLevel()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopProgressBar(progress = 1.0f)
            Spacer(modifier = Modifier.height(32.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Lealy Logo",
                    modifier = Modifier.height(48.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Lealy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Assessment Selesai!",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                color = Color(0xFF212121)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Terima kasih telah menyelesaikan assessment. Berikut hasil analisis Anda:",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                fontFamily = Poppins,
                color = Color(0xFF666666),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Level Literasi",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0057FF),
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = level,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0057FF),
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Anda sudah memiliki pemahaman dasar dan dapat melanjutkan ke praktik investasi.",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 20.sp,
                color = Color(0xFF666666),
                textAlign = TextAlign.Center,
                fontFamily = Poppins,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, Color(0xFF0057FF)),
                color = Color.White
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.MenuBook,
                        contentDescription = null,
                        tint = Color(0xFF0057FF),
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "Rekomendasi Belajar:",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = Poppins,
                            color = Color(0xFF212121)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = recommendation,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = Poppins,
                            color = Color(0xFF212121)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    // TODO: Navigasi ke halaman belajar
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp), // <- Konsisten di seluruh halaman
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0057FF),
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(horizontal = 16.dp)
            ) {
                Text(
                    text = "Mulai Belajar Sekarang",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    @Preview(showBackground = true, device = Devices.NEXUS_5)
    @Composable
    fun ResultScreenPreview() {
        val dummyViewModel = StartViewModel().apply {
            setConfidenceAnswer("Yakin untuk soal dasar")
        }
        ResultScreen(viewModel = dummyViewModel)
    }
