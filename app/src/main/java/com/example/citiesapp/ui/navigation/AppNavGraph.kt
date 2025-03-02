package com.example.citiesapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.citiesapp.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object Home: Route()
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Route.Home) {
        composable<Route.Home> {
            HomeScreen()
        }
    }
}