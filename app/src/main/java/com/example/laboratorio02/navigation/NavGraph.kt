package com.example.laboratorio02.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.laboratorio02.navigation.Screen.*
import com.example.laboratorio02.core.Constantes.Companion.ASISTENTE_ID
import com.example.laboratorio02.presentation.asistente.AsistentesScreen
import com.example.laboratorio02.presentation.update_asistentes.UpdateAsistenteScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination =  AsistentesScreen.route ){
        composable(
            route = AsistentesScreen.route
        ){
            AsistentesScreen(
                navigateToUpdateAsistenteScreen = {
                    asistenteId ->
                    navController.navigate(
                        "${UpdateAsistenteScreen.route}/${asistenteId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdateAsistenteScreen.route}/{$ASISTENTE_ID}",
            arguments = listOf(
                navArgument(ASISTENTE_ID){
                    type = NavType.IntType
                }
            )
        ){
                backStackEntry ->
            val asistenteId = backStackEntry.arguments?.getInt(ASISTENTE_ID) ?:0
            UpdateAsistenteScreen(
                asistenteId = asistenteId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}