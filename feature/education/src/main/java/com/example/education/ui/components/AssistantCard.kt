package com.example.education.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.education.R
import com.example.education.ui.theme.Poppins

@Composable
fun AssistantCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color(0xFFE0E0E0), shape = RoundedCornerShape(24.dp))
                    .clickable { onClick() }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Ikon lingkaran putih
                    Box(
                        modifier = Modifier
                            .size(44.dp)
                            .clip(CircleShape)
                            .background(Color.White),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.iconai),
                            contentDescription = "AI Icon",
                            modifier = Modifier.size(75.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    // Teks HaloAI
                    val titleText = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color(0xFF333333), fontFamily = Poppins)) {
                            append("Halo")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFF1565C0), fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontFamily = Poppins)) {
                            append("A")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFFFF9800), fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontFamily = Poppins)) {
                            append("I")
                        }
                    }

                    Text(
                        text = titleText,
                        fontSize = 16.sp,
                        fontFamily = Poppins,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "Next",
                        tint = Color(0xFF424242),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Deskripsi teks bawah
            Text(
                buildAnnotatedString {
                    // Halo (hitam)
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontFamily = Poppins
                        )
                    ) {
                        append("Halo")
                    }
                    // A (biru)
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF1565C0),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontFamily = Poppins
                        )
                    ) {
                        append("A")
                    }
                    // I (kuning)
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF9800),
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontFamily = Poppins
                        )
                    ) {
                        append("I")
                    }
                    // Teks selanjutnya (biru semua)
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF1976D2),
                            fontFamily = Poppins,
                        )
                    ) {
                        append(", asisten cerdas yang siap diajak ngobrol kapan saja")
                    }
                },
                fontSize = 14.sp,
                fontFamily = Poppins,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AssistantCardPreview() {
    MaterialTheme {
        AssistantCard()
    }
}
