package com.example.proyectoclaselocal.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.proyectoclaselocal.R
import androidx.navigation.fragment.findNavController
import com.example.proyectoclaselocal.adapter.LugarAdapter
import com.example.proyectoclaselocal.databinding.FragmentUpdateLugarBinding
import com.example.proyectoclaselocal.model.Lugar
import com.example.proyectoclaselocal.viewModel.HomeViewModel


class UpdateLugarFragment : Fragment() {
    //recuperar los elementos enviados
    private val args by navArgs<UpdateLugarFragmentArgs>()

    private var _binding: FragmentUpdateLugarBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentUpdateLugarBinding.inflate(inflater, container, false)

        // carga de datos de lugar
        binding.etNombre.setText(args.lugarArg.nombre)
        binding.etCorreo.setText(args.lugarArg.correo)
        binding.etTelefono.setText(args.lugarArg.telefono)
        binding.etWeb.setText(args.lugarArg.web)
        binding.btUpdateLugar.setOnClickListener { updateLugar() }
//        binding.btDeleteLugar.setOnClickListener { deleteLugar() }

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun updateLugar() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreo.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val web = binding.etWeb.text.toString()
        if (nombre.isNotEmpty()) {
            val lugar = Lugar(args.lugarArg.id,nombre, correo, telefono, web)
            homeViewModel.guardarLugar(lugar)
            Toast.makeText(requireContext(), getText(R.string.ms_UpdateLugar), Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateLugarFragment_to_nav_home)
        } else {
            Toast.makeText(requireContext(), getText(R.string.ms_FaltanValores), Toast.LENGTH_LONG).show()
        }
    }
}