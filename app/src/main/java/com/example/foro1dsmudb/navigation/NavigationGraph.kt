package com.example.foro1dsmudb.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foro1dsmudb.screens.LoginScreen
import com.example.foro1dsmudb.screens.WelcomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(navController = navController)
        }

        composable(
            route = "welcome/{userName}",
            arguments = listOf(
                navArgument("userName") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("userName") ?: ""
            WelcomeScreen(
                userName = userName,
                navController = navController
            )
        }
    }
}