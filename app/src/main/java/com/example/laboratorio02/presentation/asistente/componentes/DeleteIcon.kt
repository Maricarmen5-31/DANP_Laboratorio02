package com.example.laboratorio02.presentation.asistente.componentes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.laboratorio02.core.Constantes.Companion.DELETE_ASISTENTE

@Composable
fun DeleteIcon(
    deleteAsistente: () -> Unit
){
    IconButton(onClick =  deleteAsistente ) {
        Icon(imageVector = Icons.Default.Delete,
            tint = Color(0xFFC92417),
            contentDescription = DELETE_ASISTENTE,)
    }
}