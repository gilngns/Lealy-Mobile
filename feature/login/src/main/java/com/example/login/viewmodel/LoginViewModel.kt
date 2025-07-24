package com.example.login.viewmodel

import androidx.lifecycle.ViewModel
import com.example.login.model.LoginUiState
import com.example.login.util.Validator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onPhoneNumberChange(newNumber: String) {
        _uiState.update {
            it.copy(
                phoneNumber = newNumber,
                isPhoneValid = Validator.isValidPhone(newNumber)
            )
        }
    }

    fun onRegisterClick() {
        val cleanedNumber = _uiState.value.phoneNumber.trim()
        val isValid = Validator.isValidPhone(cleanedNumber)

        _uiState.update {
            it.copy(isPhoneValid = isValid)
        }

        if (isValid) {
        }
    }
}
