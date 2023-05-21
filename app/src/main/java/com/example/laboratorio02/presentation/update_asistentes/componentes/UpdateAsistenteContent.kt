package com.example.laboratorio02.presentation.update_asistentes.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio02.core.Constantes.Companion.APELLIDO
import com.example.laboratorio02.core.Constantes.Companion.NOMBRE
import com.example.laboratorio02.core.Constantes.Companion.FECHA
import com.example.laboratorio02.core.Constantes.Companion.TIPO_SANGRE
import com.example.laboratorio02.core.Constantes.Companion.CORREO
import com.example.laboratorio02.core.Constantes.Companion.TELEFONO
import com.example.laboratorio02.core.Constantes.Companion.MONTO
import com.example.laboratorio02.core.Constantes.Companion.UPDATE
import com.example.laboratorio02.domain.model.Asistente

@Composable
fun UpdateAsistenteContent(
    padding: PaddingValues,
    asistente: Asistente,
    updateNombre: (nombre: String) -> Unit,
    updateApellido: (apellido: String) -> Unit,
    updateFechaIns: (fechaIns: String) -> Unit,
    updateTipoSangre: (tipoSangre: String) -> Unit,
    updateTelefono: (telefono: Int) -> Unit,
    updateCorreo: (correo: String) -> Unit,
    updateMontoPagado: (montoPagado: Double) -> Unit,
    updateAsistente: (asistente:Asistente) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = asistente.nombre,
            onValueChange = {nombre->
                updateNombre(nombre)
            },
            label = {
                Text(NOMBRE)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.apellido,
            onValueChange = {apellido->
                updateApellido(apellido)
            },
            label = {
                Text(APELLIDO)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.fechaIns,
            onValueChange = {fechaIns->
                updateFechaIns(fechaIns)
            },
            label = {
                Text(FECHA)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.tipoSangre,
            onValueChange = {tipoSangre->
                updateTipoSangre(tipoSangre)
            },
            label = {
                Text(TIPO_SANGRE)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.telefono.toString(),
            onValueChange = {telefono->
                updateTelefono(telefono.toInt())
            },
            label = {
                Text(TELEFONO)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.correo,
            onValueChange = {correo->
                updateCorreo(correo)
            },
            label = {
                Text(CORREO)
            }
        )
        Spacer(modifier = Modifier
            .height(15.dp)
        )
        TextField(
            value = asistente.montoPagado.toString(),
            onValueChange = {monto->
                updateMontoPagado(monto.toDouble())
            },
            label = {
                Text(MONTO)
            }
        )
        Spacer(modifier = Modifier
            .height(20.dp)
        )
        Button(
            onClick = {
                updateAsistente(asistente)
                navigateBack()
            }
        ){
            Text(UPDATE)
        }
    }
}