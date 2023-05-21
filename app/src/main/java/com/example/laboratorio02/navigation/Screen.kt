package com.example.laboratorio02.navigation

import com.example.laboratorio02.core.Constantes.Companion.ASISTENTES_SCREEN
import com.example.laboratorio02.core.Constantes.Companion.UPDATE_ASISTENTES_SCREEN

sealed class Screen(val route: String){
    object AsistentesScreen: Screen(ASISTENTES_SCREEN)
    object UpdateAsistenteScreen: Screen(UPDATE_ASISTENTES_SCREEN)
}