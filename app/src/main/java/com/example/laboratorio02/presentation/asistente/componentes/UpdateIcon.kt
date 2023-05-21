package com.example.laboratorio02.presentation.asistente.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.laboratorio02.core.Constantes.Companion.UPDATE_ASISTENTE
import com.example.laboratorio02.domain.model.Asistente

@Composable
fun UpdateIcon(
    updateAsistente: Asistente,
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit
){
    IconButton(
        onClick = {
            navigateToUpdateAsistenteScreen(updateAsistente.id)
        }
    ) {
        Icon(imageVector = Icons.Default.Edit,
            tint = Color(0xFF124F9B),
            contentDescription = UPDATE_ASISTENTE
        )
    }
}