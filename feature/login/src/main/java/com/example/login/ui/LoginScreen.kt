package com.example.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.login.R
import com.example.login.ui.components.PhoneNumberInput
import com.example.login.viewmodel.LoginViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.login.model.LoginUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onPhoneNumberChange: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("ID") }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgsp1),
            contentDescription = "Header background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 24.dp, top = 40.dp)
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
                        .clickable { expanded = true }
                        .border(1.dp, Color.LightGray, RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.2f), shape = RoundedCornerShape(50))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text("\uD83C\uDF10", fontSize = 16.sp, color = Color.White)
                    Spacer(Modifier.width(6.dp))
                    Text(selectedLanguage, fontSize = 16.sp, color = Color.White)
                    Spacer(Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 180.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = Color(0xFFF7F7F7),
                shadowElevation = 0.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 100.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Sign in",
                            style = MaterialTheme.typography.headlineMedium
                        )
                        Text(
                            text = "Do the Sign In Process First",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray,
                            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
                        )

                        if (!uiState.isPhoneValid) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .heightIn(min = 50.dp)
                                    .background(
                                        color = Color.Transparent,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .border(
                                        width = 1.dp,
                                        color = Color.Red,
                                        shape = RoundedCornerShape(8.dp)
                                    )
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = "Make sure it is in the correct format",
                                    color = Color.Red,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        PhoneNumberInput(
                            value = uiState.phoneNumber,
                            onValueChange = onPhoneNumberChange,
                            isError = !uiState.isPhoneValid
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        Button(
                            onClick = onRegisterClick,
                            enabled = uiState.isPhoneValid,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF9800)
                            )
                        ) {
                            Text("Register")
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        DividerWithText(text = "Or use an account")

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = Color.Black
                            ),
                            shape = RoundedCornerShape(25.dp),
                            elevation = ButtonDefaults.buttonElevation(0.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.icgoogle),
                                contentDescription = "Google",
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Text(
                                text = "Google",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding() + 12.dp
                            ),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Already have an account? ",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Just log in!",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Blue)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoginScreenWithViewModel(viewModel: LoginViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    LoginScreen(
        uiState = uiState,
        onPhoneNumberChange = viewModel::onPhoneNumberChange,
        onRegisterClick = viewModel::onRegisterClick
    )
}

@Composable
fun DividerWithText(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Divider(
            modifier = Modifier.weight(1f),
            color = Color(0xFF888888))
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 8.dp),
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xFF888888)
        )
        Divider(
            modifier = Modifier.weight(1f),
            color = Color(0xFF888888)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(phoneNumber = "", isPhoneValid = false),
        onPhoneNumberChange = {},
        onRegisterClick = {}
    )
}
