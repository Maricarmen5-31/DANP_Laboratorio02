package com.example.laboratorio02.presentation.asistente.componentes

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.laboratorio02.domain.model.Asistente
import com.example.laboratorio02.core.Constantes.Companion.NOMBRE
import com.example.laboratorio02.core.Constantes.Companion.TELEFONO
import com.example.laboratorio02.core.Constantes.Companion.FECHA
import com.example.laboratorio02.core.Constantes.Companion.TIPO_SANGRE
import com.example.laboratorio02.core.Constantes.Companion.CORREO
import com.example.laboratorio02.core.Constantes.Companion.MONTO

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AsistenteCard(
    asistente: Asistente,
    deleteAsistente: () -> Unit,
    navigateToUpdateAsistenteScreen: (asistenteId: Int) -> Unit
){
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateAsistenteScreen(asistente.id)
        }
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column() {
                Text("${NOMBRE}: ${asistente.nombre} ${asistente.apellido}")
                Text("${FECHA}: ${asistente.fechaIns}")
                Text("${TIPO_SANGRE}: ${asistente.tipoSangre}")
                Text("${TELEFONO}: ${asistente.telefono.toString()}")
                Text("${CORREO}: ${asistente.correo}")
                Text("${MONTO}: ${asistente.montoPagado.toString()}")
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            UpdateIcon(
                updateAsistente = asistente,
                navigateToUpdateAsistenteScreen = navigateToUpdateAsistenteScreen
            )
            DeleteIcon(
                deleteAsistente = deleteAsistente
            )
        }
    }
}