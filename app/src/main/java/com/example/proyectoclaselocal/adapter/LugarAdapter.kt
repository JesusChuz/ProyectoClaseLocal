package com.example.proyectoclaselocal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoclaselocal.databinding.FragmentAddLugarBinding
import com.example.proyectoclaselocal.databinding.LugarFilaBinding
import com.example.proyectoclaselocal.model.Lugar
import com.example.proyectoclaselocal.ui.home.HomeFragmentDirections

class LugarAdapter: RecyclerView.Adapter<LugarAdapter.LugarViewHolder>(){
    //Lista de Lugares
    private var listaLugares = emptyList<Lugar>()

    fun setLugares(lugares: List<Lugar>){
        listaLugares = lugares
        notifyDataSetChanged()
    }

    inner class LugarViewHolder(private val itemBinding: LugarFilaBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun dibujo(lugar: Lugar){
            itemBinding.tvNombre.text = lugar.nombre
            itemBinding.tvCorreo.text = lugar.correo
            itemBinding.tvTelefono.text = lugar.telefono
            val accion = HomeFragmentDirections.actionNavHomeToUpdateLugarFragment(lugar)
            itemView.findNavController().navigate(accion)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding = LugarFilaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibujo(lugar)
    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }
}