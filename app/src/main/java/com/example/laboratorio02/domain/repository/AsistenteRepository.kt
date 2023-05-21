package com.example.laboratorio02.domain.repository

import com.example.laboratorio02.domain.model.Asistente
import kotlinx.coroutines.flow.Flow

typealias Asistentes = List<Asistente>

interface AsistenteRepository {
    fun getAsistentesFromRoom() : Flow<Asistentes>
    fun addAsistenteToRoom(asistente : Asistente)
    fun getAsistenteFromRoom(id: Int): Asistente
    fun updateAsistenteInRoom(asistente: Asistente)
    fun deleteAsistenteFromRoom(asistente: Asistente)

}