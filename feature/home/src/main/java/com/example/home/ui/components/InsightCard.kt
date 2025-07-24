package com.example.home.ui.components

import Poppins
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.home.R

@Composable
fun InsightCard(insight: String) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(100.dp) // ditambah
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // Gambar kiri yang "nembus"
            Image(
                painter = painterResource(id = R.drawable.insight1),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 230.dp, height = 180.dp)
                    .align(Alignment.CenterStart)
                    .offset(x = (-37).dp)
            )

            // Teks di sisi kanan
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 160.dp, end = 20.dp)
                    .wrapContentHeight(Alignment.CenterVertically),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "“$insight”",
                    fontSize = 12.sp,
                    color = Color(0xFF2D2D2D),
                    fontWeight = FontWeight.W500,
                    fontFamily = Poppins,
                    lineHeight = 22.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InsightCardPreview() {
    InsightCard(insight = "Coba pelajari perbedaan saham vs reksadana hari ini")
}
