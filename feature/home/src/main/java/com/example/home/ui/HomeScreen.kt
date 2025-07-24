package com.example.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.home.R
import com.example.home.ui.components.FeatureItem
import com.example.home.ui.components.InsightCard
import com.example.home.ui.components.ProgressCard
import curvedBottomShape

@Composable
fun HomeScreen(
    progress: Float = 0.5f,
    current: Int = 5,
    total: Int = 10,
    level: String = "Beginner",
    image1: Painter,
    image2: Painter,
    newsImage: Painter
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .padding(bottom = 60.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(curvedBottomShape(curveHeight = 80f))
        ) {
            Image(
                painter = painterResource(id = R.drawable.bghome),
                contentDescription = "Header Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Halo,\nFajarWG",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Rabu 09 Juli 2025",
                    fontSize = 12.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(12.dp))

                ProgressCard(
                    progress = progress,
                    current = current,
                    total = total,
                    level = level
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(width = 30.dp, height = 4.dp)
                            .background(Color.White, RoundedCornerShape(2.dp))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fitur Lain
        Card(
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp, bottomStart = 24.dp, bottomEnd = 24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .padding(horizontal = 32.dp)
                .offset(y = (-28).dp)
                .fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Fitur lain",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1A1A1A)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    FeatureItem(
                        title = "Manajemen\nKeuangan",
                        image = image1,
                        modifier = Modifier.weight(1f)
                    )
                    FeatureItem(
                        title = "Tanya AI",
                        image = image2,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Insight Hari Ini
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Insight Hari Ini", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1A1A1A))
            Spacer(modifier = Modifier.height(8.dp))
            InsightCard("Coba pelajari perbedaan saham vs reksadana hari ini")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Berita
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Berita", fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = Color(0xFF1A1A1A))
            Spacer(modifier = Modifier.height(8.dp))
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Today, 08:15 PM    •  7 min read", fontSize = 10.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("BEI suspend saham CDIA, manajemen tegaskan komitmen...", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            "tirto.id - Manajemen PT Chandra Daya Investasi Tbk...",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = newsImage,
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(8.dp))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF7F7F7)
@Composable
fun HomeScreenPreview() {
    val placeholder = ColorPainter(Color.LightGray)
    HomeScreen(
        image1 = placeholder,
        image2 = placeholder,
        newsImage = placeholder
    )
}
