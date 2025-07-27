package com.example.home.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EdukasiScreen() {
    Text("Halaman Edukasi", modifier = Modifier.padding(16.dp))
}

@Composable
fun SimulasiScreen() {
    Text("Halaman Simulasi", modifier = Modifier.padding(16.dp))
}

@Composable
fun ProfilScreen() {
    Text("Halaman Profil", modifier = Modifier.padding(16.dp))
}
