package com.example.onboarding.ui

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.onboarding.R
import com.example.onboarding.model.onboardingPages

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    var currentStep by remember { mutableStateOf(0) }
    val totalSteps = onboardingPages.size
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("ID") }

    val currentPage = onboardingPages[currentStep]

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        val paddingTopImage = screenHeight * 0.12f
        val imageCardWidth = screenWidth * 0.85f
        val fixedImageCardHeight = (screenHeight * 0.395f).coerceAtMost(300.dp)
        val imageSize = (screenWidth * 0.65f).coerceAtMost(240.dp)
        val cornerRadius = screenWidth * 0.06f

        Image(
            painter = painterResource(id = R.drawable.bgsp1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = screenWidth * 0.08f, top = screenHeight * 0.06f)
                .zIndex(1f)
        ) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
                modifier = Modifier.width(150.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .menuAnchor()
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) { expanded = true }
                        .border(1.dp, Color.LightGray, RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.2f), shape = RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text("🌐", fontSize = 16.sp, color = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text(selectedLanguage, fontSize = 16.sp, color = Color.White)
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_keyboard_arrow_down_24),
                        contentDescription = "Dropdown Arrow",
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(vertical = 4.dp)
                ) {
                    listOf("ID", "EN", "JP").forEach { lang ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    lang,
                                    color = Color.Black,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            },
                            onClick = {
                                selectedLanguage = lang
                                expanded = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Transparent)
                        )
                    }
                }
            }
        }

        Crossfade(targetState = currentPage) { page ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = screenWidth * 0.001f, vertical = screenHeight * 0.0001f)
                    .navigationBarsPadding()
            ) {
                Spacer(modifier = Modifier.height(paddingTopImage))

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(imageCardWidth)
                        .height(fixedImageCardHeight)
                        .clip(RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius))
                        .background(Color.White.copy(alpha = 0.2f))
                        .border(
                            width = 1.dp,
                            color = Color.White.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = page.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(imageSize)
                            .padding(16.dp),
                        contentScale = ContentScale.Fit
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius))
                        .background(Color.White)
                        .padding(
                            start = screenWidth * 0.08f,
                            end = screenWidth * 0.08f,
                            top = screenHeight * 0.04f,
                            bottom = screenHeight * 0.03f
                        )
                        .navigationBarsPadding()
                ) {
                    Text(
                        text = currentPage.title,
                        fontSize = (screenWidth.value * 0.065f).coerceAtMost(26f).sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1B1B1B)
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.02f))

                    Text(
                        text = currentPage.description,
                        fontSize = (screenWidth.value * 0.035f).coerceAtMost(14f).sp,
                        color = Color(0xFF1B1B1B)
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.03f))

                    OnboardingIndicator(
                        size = totalSteps,
                        currentPage = currentStep,
                        screenWidth = screenWidth,
                        screenHeight = screenHeight
                    )

                    Spacer(modifier = Modifier.height(screenHeight * 0.04f))

                    Button(
                        onClick = {
                            if (currentStep < totalSteps - 1) currentStep++ else onFinish()
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9800)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(screenHeight * 0.07f)
                    ) {
                        Text(
                            text = if (currentStep == totalSteps - 1) "Next" else "Next",
                            fontSize = (screenWidth.value * 0.045f).sp,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(screenHeight * 0.02f))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Divider(modifier = Modifier.weight(1f), color = Color(0xFF888888))
                        Text(
                            text = "  Or use an account  ",
                            fontSize = (screenWidth.value * 0.045f).sp,
                            color = Color(0xFF888888)
                        )
                        Divider(modifier = Modifier.weight(1f), color = Color(0xFF888888))
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "Skip",
                        color = Color.Black,
                        fontSize = (screenWidth.value * 0.045f).sp,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onFinish() }
                            .padding(8.dp)
                    )

                }
            }
        }
    }
}

@Composable
fun OnboardingIndicator(
    size: Int,
    currentPage: Int,
    screenWidth: Dp,
    screenHeight: Dp
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = screenWidth * 0.08f),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(size) { index ->
            Box(
                modifier = Modifier
                    .height(screenHeight * 0.008f)
                    .weight(1f)
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (index <= currentPage) Color(0xFFFF9800)
                        else Color(0xFFE0E0E0)
                    )
            )
            if (index != size - 1) {
                Spacer(modifier = Modifier.width(screenWidth * 0.02f))
            }
        }
    }
}

@Composable
fun Float.dpToSp(): TextUnit {
    val density = LocalDensity.current
    return with(density) { this@dpToSp.dp.toSp() }
}

@Preview(device = Devices.PIXEL_2)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onFinish = {})
}
