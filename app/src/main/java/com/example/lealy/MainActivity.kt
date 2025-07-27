package com.example.lealy

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.home.ui.MainScreen
import com.example.lealy.ui.theme.LealyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()
        var keepSplashScreen = true
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            keepSplashScreen = false
        }, 3000)

        // ✅ Izinkan menggambar di belakang status bar
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // ✅ Behavior agar status bar bisa disembunyikan dan muncul saat swipe
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        controller.hide(WindowInsetsCompat.Type.statusBars())

        // ✅ Navigation bar tetap putih
        window.navigationBarColor = android.graphics.Color.WHITE
        controller.isAppearanceLightNavigationBars = true

        // ✅ Status bar transparan dengan icon putih
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        controller.isAppearanceLightStatusBars = false

        // ✅ Pantau insets untuk mendeteksi jika user swipe status bar
        ViewCompat.setOnApplyWindowInsetsListener(window.decorView) { view, insets ->
            val isStatusBarVisible = insets.isVisible(WindowInsetsCompat.Type.statusBars())
            if (isStatusBarVisible) {
                Handler(Looper.getMainLooper()).postDelayed({
                    controller.hide(WindowInsetsCompat.Type.statusBars())
                }, 3000) // Delay 3 detik, lalu sembunyikan status bar lagi
            }
            ViewCompat.onApplyWindowInsets(view, insets)
        }

        setContent {
            LealyTheme {
                MainScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                )
            }
        }
    }
}
