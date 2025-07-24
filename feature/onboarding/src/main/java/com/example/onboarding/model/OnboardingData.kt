package com.example.onboarding.model

import androidx.annotation.DrawableRes
import com.example.onboarding.R

data class OnboardingPage(
    @DrawableRes val imageRes: Int,
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        imageRes = R.drawable.sp1,
        title = "Investing Made Simple",
        description = "Start your investment journey with easy steps and interactive guidance in this app."
    ),
    OnboardingPage(
        imageRes = R.drawable.sp2,
        title = "Learn to Invest, Achieve Your Future",
        description = "Enhance your financial knowledge and reach your goals by learning the basics of investing."
    ),
    OnboardingPage(
        imageRes = R.drawable.sp3,
        title = "Smart Investing, Smart Finances",
        description = "Access to health, wealth, and protection in a single touchpoint."
    )
)
