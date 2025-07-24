package com.example.start.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StartViewModel : ViewModel() {

    private val _confidenceAnswer = MutableStateFlow<String?>(null)
    val confidenceAnswer: StateFlow<String?> = _confidenceAnswer

    fun setConfidenceAnswer(answer: String) {
        _confidenceAnswer.value = answer
    }

    fun getLevelFromAnswer(): String {
        return when (_confidenceAnswer.value) {
            "Tidak yakin sama sekali" -> "Pemula"
            "Yakin untuk soal dasar" -> "Intermediate"
            "Yakin sampai soal menengah" -> "Intermediate"
            "Yakin untuk soal lanjutan" -> "Lanjutan"
            else -> "Tidak diketahui"
        }
    }

    fun getRecommendationFromLevel(): String {
        return when (getLevelFromAnswer()) {
            "Pemula" -> "Pelajari dulu dasar-dasar investasi sebelum mencoba praktik langsung."
            "Intermediate" -> "Anda dapat melewati pengenalan dan langsung mulai praktik instrumen investasi."
            "Lanjutan" -> "Ikuti simulasi lanjutan dan eksplorasi strategi tingkat lanjut."
            else -> "-"
        }
    }
}
