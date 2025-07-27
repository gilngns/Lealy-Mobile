package com.example.home.ui.components

import Poppins
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.home.R

@Composable
fun BeritaCard(
    time: String,
    readDuration: String,
    title: String,
    description: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            // Left side for Text
            Column(modifier = Modifier.weight(1f)) {
                // Time & Read Duration
                Text(
                    "$time    •  $readDuration",
                    fontSize = 11.sp,
                    color = Color(0xFF9A9A9A) // abu muda seperti di Figma
                )
                Spacer(modifier = Modifier.height(4.dp))

                // Title
                Text(
                    title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))

                // Description
                Text(
                    description,
                    fontSize = 13.sp,
                    color = Color(0xFF666666), // abu gelap
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Image section
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 80.dp, height = 80.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BeritaCardPreview() {
    BeritaCard(
        time = "Today, 08:15 PM",
        readDuration = "7 min read",
        title = "BEI suspend saham CDIA, manajemen tegaskan komitmen...",
        description = "tirto.id - Manajemen PT Chandra Daya Investasi Tbk...",
        image = painterResource(id = R.drawable.berita)
    )
}
