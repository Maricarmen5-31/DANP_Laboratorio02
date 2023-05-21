package com.example.laboratorio02.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.laboratorio02.core.Constantes.Companion.ASISTENTE_TABLE

@Entity(tableName = ASISTENTE_TABLE)
data class Asistente(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val nombre : String,
    val apellido : String,
    val fechaIns : String,
    val tipoSangre : String,
    val telefono : Int,
    val correo : String,
    val montoPagado : Double
)
