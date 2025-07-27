package com.example.home.ui

import Poppins
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.home.R
import com.example.home.ui.components.BeritaCard
import com.example.home.ui.components.FeatureItem
import com.example.home.ui.components.InsightCard
import com.example.home.ui.components.ProgressCard
import com.example.home.ui.components.SimulationPortfolioCard
import com.example.home.ui.theme.BluePrimary
import curvedBottomShape

@Composable
fun HomeScreen() {
    HomeScreenContent(
        progress = 0.5f,
        current = 5,
        total = 10,
        level = "Beginner",
        image1 = painterResource(id = R.drawable.iconmk),
        image2 = painterResource(id = R.drawable.iconai),
        newsImage = painterResource(id = R.drawable.berita),
        backgroundImage = painterResource(id = R.drawable.bghome)
    )
}

@Composable
fun HomeScreenContent(
    progress: Float,
    current: Int,
    total: Int,
    level: String,
    image1: Painter,
    image2: Painter,
    newsImage: Painter,
    backgroundImage: Painter,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState(pageCount = { 2 })
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val horizontalPadding = 24.dp
    val cardWidth = screenWidth - (horizontalPadding * 2)
    val headerHeight = (screenHeight * 0.42f).coerceIn(350.dp, 400.dp)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
            .verticalScroll(scrollState)
            .padding(bottom = 60.dp)
    ) {
        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(headerHeight)
                .clip(curvedBottomShape())
                .background(BluePrimary)
                .systemBarsPadding()
        ) {
            Image(
                painter = backgroundImage,
                contentDescription = "Header Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .statusBarsPadding()
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically // Ubah jadi center
                ) {
                    Column {
                        Text(
                            text = "Halo,\nFajarWG",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = FontFamily.Default
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Rabu 09 Juli 2025",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W300,
                            fontFamily = FontFamily.Default
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White.copy(alpha = 0.15f), shape = RoundedCornerShape(12.dp))
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = { /* TODO */ }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.lonceng),
                            contentDescription = "Notifikasi",
                            tint = Color.White
                        )
                    }
                }

                // Pager: ProgressCard & SimulationPortfolioCard
                HorizontalPager(
                    state = pagerState,
                    pageSize = PageSize.Fixed(cardWidth),
                    pageSpacing = 12.dp,
                    contentPadding = PaddingValues(start = horizontalPadding - 24.dp, end = horizontalPadding),
                            modifier = Modifier
                        .wrapContentHeight()
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 24.dp, bottom = 13.dp)
                ) { page ->
                    val cardModifier = Modifier
                        .width(cardWidth)
                        .heightIn(min = 118.dp)

                    when (page) {
                        0 -> ProgressCard(
                            progress = progress,
                            current = current,
                            total = total,
                            level = level,
                            modifier = cardModifier
                        )
                        1 -> SimulationPortfolioCard(
                            totalAmount = "1.000.000",
                            growthAmount = "150.000",
                            growthPercent = "2.5%",
                            modifier = cardModifier
                        )
                    }
                }

                // Rectangle indicator
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    repeat(2) { index ->
                        Box(
                            modifier = Modifier
                                .height(4.dp)
                                .width(if (pagerState.currentPage == index) 28.dp else 28.dp)
                                .background(
                                    color = if (pagerState.currentPage == index) Color.White else Color.White.copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(2.dp)
                                )
                        )
                    }
                }
            }
        }

        // FITUR LAIN
        Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-45).dp) // Tetap naikkan fitur
                .padding(horizontal = 18.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Fitur lain",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A),
                    fontFamily = FontFamily.Default
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    FeatureItem(title = "Manajemen Keuangan", image = image1, modifier = Modifier.weight(1f))
                    FeatureItem(title = "Tanya AI", image = image2, modifier = Modifier.weight(1f))
                }
            }
        }

        // INSIGHT - ditarik naik agar tidak terlalu jauh
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-20).dp) // Tarik ke atas agar lebih dekat ke fitur
                .padding(horizontal = 18.dp)
        ) {
            Text(
                "Insight Hari Ini",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A1A1A),
                fontFamily = Poppins
            )
            Spacer(modifier = Modifier.height(5.dp))
            InsightCard(
                insight = "Coba pelajari perbedaan saham vs reksadana hari ini",
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        // BERITA
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text("Berita", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1A1A1A), fontFamily = Poppins)
            Spacer(modifier = Modifier.height(8.dp))
            BeritaCard(
                time = "Today, 09:00 AM",
                readDuration = "5 min read",
                title = "IHSG dibuka menguat, investor asing catat net buy",
                description = "IDX membuka perdagangan dengan tren positif didorong sektor teknologi dan energi.",
                image = newsImage
            )
            Spacer(modifier = Modifier.height(8.dp))
            BeritaCard(
                time = "Today, 11:20 AM",
                readDuration = "4 min read",
                title = "OJK rilis regulasi baru untuk fintech lending",
                description = "OJK resmi mengumumkan aturan penguatan mitigasi risiko pinjaman online.",
                image = newsImage
            )
            Spacer(modifier = Modifier.height(8.dp))
            BeritaCard(
                time = "Today, 02:45 PM",
                readDuration = "6 min read",
                title = "Harga emas naik tipis di tengah pelemahan dolar AS",
                description = "Logam mulia kembali menguat setelah the Fed mengisyaratkan sikap dovish.",
                image = newsImage
            )
        }
    }
}

@Preview(showBackground = false, backgroundColor = 0xFFF7F7F7, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    val placeholder = ColorPainter(Color.LightGray)
    Surface {
        HomeScreenContent(
            progress = 0.5f,
            current = 5,
            total = 10,
            level = "Beginner",
            image1 = placeholder,
            image2 = placeholder,
            newsImage = placeholder,
            backgroundImage = placeholder
        )
    }
}