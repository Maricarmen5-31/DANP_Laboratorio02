package com.example.laboratorio02.data.repository

import com.example.laboratorio02.data.network.AsistenteDao
import com.example.laboratorio02.domain.model.Asistente
import com.example.laboratorio02.domain.repository.AsistenteRepository

class AsistenteRepositoryImpl (
    private  val asistenteDao: AsistenteDao
    ): AsistenteRepository {
        // getAsistentes
        override fun getAsistentesFromRoom() = asistenteDao.getAsistentes()

        // addAsistente
        override fun addAsistenteToRoom(asistente: Asistente) = asistenteDao.addAsistente(asistente)

        // getAsistente
        override fun getAsistenteFromRoom(id: Int) = asistenteDao.getAsistente(id)

        // updateAsistente
        override fun updateAsistenteInRoom(asistente: Asistente) =
            asistenteDao.updateAsistente(asistente)

        // deleteAsistente
        override fun deleteAsistenteFromRoom(asistente: Asistente) =
            asistenteDao.deleteAsistente(asistente)
}