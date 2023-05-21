package com.example.laboratorio02.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.laboratorio02.domain.model.Asistente

@Database(entities = [Asistente::class], version = 1, exportSchema = false)
abstract  class AsistenteDB: RoomDatabase() {
    abstract fun asistenteDao(): AsistenteDao
}