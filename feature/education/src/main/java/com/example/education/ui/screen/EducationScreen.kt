package com.example.education.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.education.R
import com.example.education.ui.component.AssistantCard
import com.example.education.ui.components.CategoryCard
import com.example.education.ui.components.HistoryCard
import com.example.education.ui.components.LessonCard
import com.example.education.ui.components.SearchBar
import com.example.education.ui.theme.Poppins

@Composable
fun EducationScreen(
    backgroundPainter: Painter? = painterResource(id = R.drawable.bg_education)
) {
    var searchQuery by remember { mutableStateOf("") }
    val dummyClick: () -> Unit = {}

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // HEADER BIRU
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(210.dp)
            ) {
                backgroundPainter?.let {
                    Image(
                        painter = it,
                        contentDescription = "Header Background",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.matchParentSize()
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .padding(top = 48.dp)
                ) {
                    Text(
                        text = "Edukasi Investasi",
                        fontFamily = Poppins,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    SearchBar(
                        query = searchQuery,
                        onQueryChange = { searchQuery = it }
                    )
                }
            }
        }

        // BACKGROUND PUTIH + BUNDARAN ATAS
        item {
            Spacer(modifier = Modifier.height(1.dp)) // trick untuk mulai transisi
        }

        // ASSISTANT CARD
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = Color.White,
                        shape = MaterialTheme.shapes.large.copy(
                            topStart = CornerSize(32.dp),
                            topEnd = CornerSize(32.dp)
                        )
                    )
            ) {
                AssistantCard(
                    onClick = dummyClick,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .offset(y = (-30).dp)
                )
            }
        }

        // KATEGORI EDUKASI
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Kategori Edukasi",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        CategoryCard(
                            title = "Basic",
                            backgroundColor = Color(0x33E35B2D),
                            textColor = Color(0xFFE65100),
                            iconRes = R.drawable.iconbasic,
                            onClick = dummyClick
                        )
                    }
                    item {
                        CategoryCard(
                            title = "Intermediate",
                            backgroundColor = Color(0x332E7D32),
                            textColor = Color(0xFF2E7D32),
                            iconRes = R.drawable.iconintermediate,
                            onClick = dummyClick
                        )
                    }
                    item {
                        CategoryCard(
                            title = "Expert",
                            backgroundColor = Color(0x331565C0),
                            textColor = Color(0xFF1565C0),
                            iconRes = R.drawable.iconexpert,
                            onClick = dummyClick
                        )
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))
            }
        }

        // PELAJARAN TERPOPULER
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Pelajaran terpopuler",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                val scrollState = rememberLazyListState()

                LazyRow(
                    state = scrollState,
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(3) {
                        LessonCard(
                            title = "Mengapa Kita Perlu Berinvestasi?",
                            level = "Basic",
                            duration = "5 min",
                            rating = "4.7",
                            views = "100k",
                            imageRes = R.drawable.lessonbasic,
                            onClick = dummyClick
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        // HISTORY BELAJAR
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = "Sebelumnya",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF212121),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    HistoryCard(
                        title = "Analisis Laporan Keuangan",
                        dateInfo = "1 hari yang lalu",
                        imageRes = R.drawable.lessonbasic,
                        onClick = dummyClick
                    )
                    HistoryCard(
                        title = "Membangun Portofolio yang Efektif",
                        dateInfo = "2 hari yang lalu",
                        imageRes = R.drawable.lessonbasic,
                        onClick = dummyClick
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EducationScreenPreview() {
    MaterialTheme {
        EducationScreen()
    }
}
