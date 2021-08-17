package com.steve.bottomnavigationcompose

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen (var route: String, @StringRes val resourceId: Int, var icon: ImageVector) {
    object Home : Screen("home", R.string.home, Icons.Default.Home)
    object Search : Screen("search",R.string.search, Icons.Default.Search )
    object Settings : Screen("library", R.string.settings, Icons.Default.Settings)
    object Profile : Screen("profile", R.string.profile, Icons.Default.Person)
}
