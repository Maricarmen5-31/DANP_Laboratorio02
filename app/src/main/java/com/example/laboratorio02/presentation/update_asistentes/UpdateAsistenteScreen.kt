package com.example.laboratorio02.presentation.update_asistentes

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.laboratorio02.presentation.update_asistentes.componentes.UpdateAsistenteContent
import com.example.laboratorio02.presentation.update_asistentes.componentes.UpdateAsistenteTopBar
import com.example.laboratorio02.presentation.asistente.AsistentesViewModel

@Composable
fun UpdateAsistenteScreen(
    viewModel: AsistentesViewModel = hiltViewModel(),
    asistenteId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getAsistente(asistenteId)
    }
    Scaffold(
        topBar = {
            UpdateAsistenteTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateAsistenteContent(
                padding = padding,
                asistente = viewModel.asistente,
                updateNombre = { nombre->
                    viewModel.updateNombre(nombre)
                },
                updateApellido = {apellido->
                    viewModel.updateApellido(apellido)
                },
                updateFechaIns = {fecha->
                    viewModel.updateFechaIns(fecha)
                },
                updateTipoSangre = {tipoSangre->
                    viewModel.updateTipoSangre(tipoSangre)
                },
                updateTelefono = {telefono->
                    viewModel.updateTelefono(telefono)
                },
                updateCorreo = {correo->
                    viewModel.updateCorreo(correo)
                },
                updateMontoPagado = {monto->
                    viewModel.updateMonto(monto)
                },
                updateAsistente = {asistente ->
                    viewModel.updateAsistente(asistente)
                },
                navigateBack = navigateBack
            )
        }
    )
}