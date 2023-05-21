package com.example.laboratorio02.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import com.example.laboratorio02.core.Constantes.Companion.ASISTENTE_TABLE
import com.example.laboratorio02.domain.model.Asistente
import com.example.laboratorio02.domain.repository.Asistentes
import kotlinx.coroutines.flow.Flow

@Dao
interface AsistenteDao {

    //getAsistentes
    @Query("SELECT * FROM $ASISTENTE_TABLE ORDER BY id ASC")
    fun getAsistentes(): Flow<Asistentes>

    //addAsistente
    @Insert(onConflict = IGNORE)
    fun addAsistente(asistente: Asistente)

    // getAsistente
    @Query("SELECT * FROM $ASISTENTE_TABLE WHERE id = :id")
    fun getAsistente(id: Int): Asistente

    // updateAsistente
    @Update
    fun updateAsistente(asistente: Asistente)

    // deleteAsistente
    @Delete
    fun deleteAsistente(asistente: Asistente)
}