package com.example.home.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.home.ui.theme.BluePrimary

data class BottomNavItem(
    val label: String,
    @DrawableRes val iconActiveRes: Int,
    @DrawableRes val iconInactiveRes: Int,
    val route: String
)


val BottomNavItems = listOf(
    BottomNavItem("home", R.drawable.homeact, R.drawable.nav1, "home"),
    BottomNavItem("edukasi", R.drawable.bookact, R.drawable.nav2, "edukasi"),
    BottomNavItem("simulasi", R.drawable.directrightact, R.drawable.nav3, "simulasi"),
    BottomNavItem("profil", R.drawable.profileact, R.drawable.nav4, "profil")
)

@Composable
fun BottomNavBar(
    currentRoute: String,
    onItemSelected: (BottomNavItem) -> Unit
) {
    NavigationBar(
        tonalElevation = 6.dp,
        containerColor = Color.White
    ) {
        BottomNavItems.forEach { item ->
            val isSelected = currentRoute == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemSelected(item) },
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.iconActiveRes else item.iconInactiveRes
                        ),
                        contentDescription = item.label,
                        modifier = Modifier.size(33.dp),
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        text = item.label.replaceFirstChar { it.uppercase() },
                        color = if (isSelected) BluePrimary else Color.Gray
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}

