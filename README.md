# Compose-Bottom-Navigation
Implementing bottom navigation in jetpack compose

### Add the Navigation dependency
Open the app's build file, found at ```app/build.gradle. ``` In the dependencies section, add the ```navigation-compose ``` dependency.

```kotlin

dependencies {
  implementation "androidx.navigation:navigation-compose:2.4.0-alpha04"
  // other dependencies
}

```

You can create a```NavController``` by using the ```rememberNavController() ```method in your composable:
```kotlin
val navController = rememberNavController()

```
### Add screens
```kotlin
sealed class Screen (var route: String, @StringRes val resourceId: Int, var icon: ImageVector) {
    object Home : Screen("home", R.string.home, Icons.Default.Home)
    object Search : Screen("search",R.string.search, Icons.Default.Search )
    object Settings : Screen("library", R.string.settings, Icons.Default.Settings)
    object Profile : Screen("profile", R.string.profile, Icons.Default.Person)
}


```

Then place those items in a list that can be used by the BottomNavigationItem
```kotlin
val items = listOf(Screen.Home, Screen.Search, Screen.Settings, Screen.Profile)
)
```
Set bottom navigation at your composable function
```kotlin
 val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }

            }

        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Home.route, Modifier.padding(innerPadding)) {
            composable(Screen.Home.route) { Home(navController) }
            composable(Screen.Search.route) { Search(navController) }
            composable(Screen.Settings.route) {Settings(navController) }
            composable(Screen.Profile.route) { Profile(navController) }
        }
    }
}

```
