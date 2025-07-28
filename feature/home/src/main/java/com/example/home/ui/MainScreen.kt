// MainScreen.kt
package com.example.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.education.ui.screen.EducationScreen
import com.example.home.ui.components.BottomNavBar
import com.example.home.ui.components.BottomNavItems

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedRoute by remember { mutableStateOf(BottomNavItems.first().route) }

    val showBottomBar = selectedRoute != "profil"

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(
                    currentRoute = selectedRoute,
                    onItemSelected = { selectedRoute = it.route }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedRoute) {
                "home" -> HomeScreen()
                "edukasi" -> EducationScreen()
                "simulasi" -> SimulasiScreen()
                "profil" -> ProfilScreen()
            }
        }
    }
}
