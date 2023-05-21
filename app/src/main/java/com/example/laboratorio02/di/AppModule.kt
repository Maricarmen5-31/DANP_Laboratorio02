package com.example.laboratorio02.di

import android.content.Context
import androidx.room.Room
import com.example.laboratorio02.core.Constantes.Companion.ASISTENTE_TABLE
import com.example.laboratorio02.data.network.AsistenteDB
import com.example.laboratorio02.data.network.AsistenteDao
import com.example.laboratorio02.data.repository.AsistenteRepositoryImpl
import com.example.laboratorio02.domain.repository.AsistenteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideAsistenteDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        AsistenteDB::class.java,
        ASISTENTE_TABLE
    ).build()

    @Provides
    fun provideAsistenteDao(
        asistenteDB: AsistenteDB
    ) = asistenteDB.asistenteDao()

    @Provides
    fun provideAsistenteRepository(
        asistenteDao: AsistenteDao
    ): AsistenteRepository = AsistenteRepositoryImpl(
        asistenteDao = asistenteDao
    )

}