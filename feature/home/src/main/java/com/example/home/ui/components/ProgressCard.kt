package com.example.home.ui.components

import Poppins
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.home.R

@Composable
fun ProgressCard(
    progress: Float,
    current: Int,
    total: Int,
    level: String,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardHeight = screenWidth * 0.27f
    val progressBoxSize = screenWidth * 0.2f

    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(progressBoxSize)
                    .background(Color.White.copy(alpha = 0.1f), RoundedCornerShape(12.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${(progress * 100).toInt()}%",
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.poppins_bold))
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "Progress Pelajaran Anda",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = Poppins
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    "Level Literasi: $level",
                    color = Color.White.copy(alpha = 0.85f),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = Poppins
                )

                Spacer(modifier = Modifier.height(10.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp)
                        .clip(RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.3f))
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(progress.coerceIn(0f, 1f))
                            .clip(RoundedCornerShape(50))
                            .background(Color.White)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "$current dari $total video sudah selesai!",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontFamily = Poppins
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SimulationPortfolioCard(
    totalAmount: String,
    growthAmount: String,
    growthPercent: String,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardHeight = screenWidth * 0.27f

    Card(
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.White.copy(alpha = 0.5f)),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = modifier
            .fillMaxWidth()
            .height(cardHeight)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Total Simulation Portfolio",
                    fontSize = 12.sp,
                    color = Color.White.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Rp $totalAmount",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .background(Color(0xFFDCF5EC), shape = RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.TrendingUp,
                            contentDescription = "Up",
                            tint = Color(0xFF12B76A),
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Rp$growthAmount (+$growthPercent)",
                            fontSize = 12.sp,
                            color = Color(0xFF12B76A),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            IconButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .size(36.dp)
                    .border(1.dp, Color.White.copy(alpha = 0.5f), shape = RoundedCornerShape(10.dp))
            ) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "Next",
                    tint = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF1A73E8,
    device = Devices.PIXEL_4_XL
)
@Composable
fun PreviewCards() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(17.dp)
    ) {
        ProgressCard(
            progress = 0.5f,
            current = 5,
            total = 10,
            level = "Beginner"
        )
        Spacer(modifier = Modifier.height(16.dp))
        SimulationPortfolioCard(
            totalAmount = "1.000.000,00",
            growthAmount = "230.450",
            growthPercent = "1.4%"
        )
    }
}