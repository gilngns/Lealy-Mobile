package com.example.home.ui.components

import Poppins
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import com.example.home.R

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun InsightCard(
    insight: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val imageWidth = maxWidth * 0.55f
            val imageOffset = (-maxWidth * 0.08f)

            Image(
                painter = painterResource(id = R.drawable.insight1),
                contentDescription = null,
                modifier = Modifier
                    .width(imageWidth)
                    .height(180.dp)
                    .align(Alignment.CenterStart)
                    .offset(x = imageOffset)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = maxWidth * 0.45f, end = 16.dp)
                    .wrapContentHeight(Alignment.CenterVertically),
                verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center
            ) {
                Text(
                    text = "“$insight”",
                    fontSize = 12.sp,
                    color = Color(0xFF2D2D2D),
                    fontWeight = FontWeight.W500,
                    fontFamily = Poppins,
                    lineHeight = 20.sp
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
