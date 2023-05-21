package com.example.laboratorio02.presentation.asistente

import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.laboratorio02.core.Constantes.Companion.ASISTENTES_SCREEN
import com.example.laboratorio02.domain.model.Asistente
import com.example.laboratorio02.presentation.asistente.componentes.AddAsistenteAlertDialog
import com.example.laboratorio02.presentation.asistente.componentes.AddAsistenteFloatingActionButton
import com.example.laboratorio02.presentation.asistente.componentes.AsistentesContent

@Composable
fun AsistentesScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit
){
    val asistentes by viewModel.asistentes.collectAsState(
        initial = emptyList() )
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(ASISTENTES_SCREEN)
            })
        },
        content = {
                padding->
            AsistentesContent(
                padding = padding,
                asistentes = asistentes,
                deleteAsistente = { asistente ->
                    viewModel.deleteAsistente(asistente)
                },
                navigateToUpdateAsistenteScreen =
                navigateToUpdateAsistenteScreen
            )
            AddAsistenteAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addAsistente = {asistente->
                    viewModel.addAsistente(asistente)
                }
            )
        },
        floatingActionButton = {
            AddAsistenteFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}