package com.example.proyectoclaselocal.repository

import androidx.lifecycle.LiveData
import com.example.proyectoclaselocal.data.LugarDao
import com.example.proyectoclaselocal.model.Lugar

class LugarRepository(private val lugarDao: LugarDao){
    suspend fun guardarLugar(lugar:Lugar){
        if(lugar.id == 0){
            lugarDao.agregarLugar(lugar)
        }else{
            lugarDao.actualizarLugar(lugar)
        }
    }
    suspend fun eliminarLugar(lugar: Lugar){
        lugarDao.eliminarLugar(lugar)
    }

    val obtenerLugares: LiveData<List<Lugar>> = lugarDao.getLugares()

}