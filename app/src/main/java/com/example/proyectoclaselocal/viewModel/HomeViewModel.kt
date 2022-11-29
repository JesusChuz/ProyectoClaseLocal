package com.example.proyectoclaselocal.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectoclaselocal.data.LugarDatabase
import com.example.proyectoclaselocal.model.Lugar
import com.example.proyectoclaselocal.repository.LugarRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: LugarRepository
    val obtenerLugares: LiveData<List<Lugar>>

    init {
        val lugarDao = LugarDatabase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
        obtenerLugares = repository.obtenerLugares
    }
    fun guardarLugar(lugar: Lugar){
        viewModelScope.launch { repository.guardarLugar(lugar) }
    }
    fun eliminarLugar(lugar: Lugar){
        viewModelScope.launch { repository.eliminarLugar(lugar) }
    }
}