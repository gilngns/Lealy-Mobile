package com.example.lealy

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.lealy.ui.theme.LealyTheme
import com.example.start.presentation.StartNavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // SplashScreen Android 12+
        val splashScreen = installSplashScreen()

        var keepSplashScreen = true
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)

        // Tahan splash selama 3 detik
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplashScreen = false
        }, 3000)

        setContent {
            LealyTheme {
                val navController = rememberNavController()

                StatusBarVisibility()

                StartNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun StatusBarVisibility() {
    val context = LocalContext.current
    val activity = context as? Activity

    LaunchedEffect(Unit) {
        activity?.let {
            val window = it.window
            val controller = WindowInsetsControllerCompat(window, window.decorView)

            WindowCompat.setDecorFitsSystemWindows(window, true)
            window.statusBarColor = android.graphics.Color.WHITE
            controller.isAppearanceLightStatusBars = true
        }
    }
}
