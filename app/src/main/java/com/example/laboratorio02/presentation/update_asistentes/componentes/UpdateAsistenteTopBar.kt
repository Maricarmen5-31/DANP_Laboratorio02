package com.example.laboratorio02.presentation.update_asistentes.componentes

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.example.laboratorio02.core.Constantes.Companion.UPDATE_ASISTENTES_SCREEN

@Composable
fun UpdateAsistenteTopBar (
    navigateBack: () -> Unit
){
    TopAppBar(
        title = {
            Text(UPDATE_ASISTENTES_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null)
            }
        }
    )
}