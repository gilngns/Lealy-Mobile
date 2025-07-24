package com.example.login.util

object Validator {
    /**
     * Validasi input seperti: 81993234987
     * Panjang total dengan 62 harus 11-12 digit: 6281993234987 ✅
     */
    fun isValidPhone(phone: String): Boolean {
        val cleaned = phone.trim().replace(" ", "")
        val formatted = "62$cleaned"
        val regex = Regex("^62\\d{11,12}$")
        return regex.matches(formatted)
    }

    /**
     * Format agar siap dikirim ke OTP API, dalam bentuk +62xxxxxxxxxxx
     */
    fun formatPhoneForOtp(phone: String): String {
        val cleaned = phone.trim().replace(" ", "")
        return "+62$cleaned"
    }
}
