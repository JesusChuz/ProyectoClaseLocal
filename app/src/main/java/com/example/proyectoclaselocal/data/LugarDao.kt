package com.example.proyectoclaselocal.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.proyectoclaselocal.model.Lugar

@Dao
interface LugarDao {
    @Query("Select * from Lugar")
    fun getLugares(): LiveData<List<Lugar>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarLugar(Lugar : Lugar)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun actualizarLugar(lugar: Lugar)

    @Delete
    suspend fun eliminarLugar(lugar: Lugar)
}