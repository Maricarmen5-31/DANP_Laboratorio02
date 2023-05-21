package com.example.laboratorio02.presentation.asistente.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.laboratorio02.core.Constantes.Companion.ADD
import com.example.laboratorio02.core.Constantes.Companion.DISMISS
import com.example.laboratorio02.core.Constantes.Companion.ADD_ASISTENTE
import com.example.laboratorio02.core.Constantes.Companion.APELLIDO
import com.example.laboratorio02.core.Constantes.Companion.CORREO
import com.example.laboratorio02.core.Constantes.Companion.FECHA
import com.example.laboratorio02.core.Constantes.Companion.MONTO
import com.example.laboratorio02.core.Constantes.Companion.NOMBRE
import com.example.laboratorio02.core.Constantes.Companion.NO_VALUE
import com.example.laboratorio02.core.Constantes.Companion.TELEFONO
import com.example.laboratorio02.core.Constantes.Companion.TIPO_SANGRE
import com.example.laboratorio02.domain.model.Asistente
import kotlinx.coroutines.job

@Composable
fun AddAsistenteAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addAsistente: (asistente: Asistente) -> Unit
){
    if (openDialog){
        var nombre by remember { mutableStateOf(NO_VALUE)}
        var apellido by remember { mutableStateOf(NO_VALUE)}
        var fechaIns by remember { mutableStateOf(NO_VALUE)}
        var tipoSangre by remember { mutableStateOf(NO_VALUE)}
        var telefono by remember { mutableStateOf(NO_VALUE)}
        var correo by remember { mutableStateOf(NO_VALUE)}
        var monto by remember { mutableStateOf(NO_VALUE)}
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_ASISTENTE)
            },
            text = {
                Column {
                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )
                    TextField(
                        value = nombre,
                        onValueChange = {nombre = it},
                        label = {
                            Text(NOMBRE)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = apellido,
                        onValueChange = {apellido = it},
                        label = {
                            Text(APELLIDO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = fechaIns,
                        onValueChange = {fechaIns = it},
                        label = {
                            Text(FECHA)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = tipoSangre,
                        onValueChange = {tipoSangre = it},
                        label = {
                            Text(TIPO_SANGRE)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = telefono,
                        onValueChange = {telefono = it},
                        label = {
                            Text(TELEFONO)
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = correo,
                        onValueChange = {correo = it},
                        label = {
                            Text(CORREO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(13.dp)
                    )
                    TextField(
                        value = monto,
                        onValueChange = {monto = it},
                        label = {
                            Text(MONTO)
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val asistente = Asistente(0,nombre, apellido, fechaIns, tipoSangre, telefono.toInt(), correo, monto.toDouble())
                        addAsistente(asistente)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog) {
                    Text(DISMISS)
                }
            }
        )
    }
}