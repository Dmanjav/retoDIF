package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.R
import mx.itesm.difood.ViewModel.RegistrarMenuViewModel
import mx.itesm.difood.databinding.FragmentRegistrarMenuBinding

class RegistrarMenu : Fragment() {
    private  lateinit var binding: FragmentRegistrarMenuBinding
    companion object {
        fun newInstance() = RegistrarMenu()
    }

    private lateinit var viewModel: RegistrarMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrarMenuBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrarMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnRegistrar.setOnClickListener{
            val accion = RegistrarMenuDirections.actionRegistrarMenuToPrincipal()
            findNavController().navigate(accion)
        }
    }

}