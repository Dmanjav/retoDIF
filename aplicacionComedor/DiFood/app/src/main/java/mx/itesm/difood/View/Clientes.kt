package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.ClientesViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentClientesBinding

class Clientes : Fragment() {
    private lateinit var binding: FragmentClientesBinding
    var token:String = ""
    companion object {
        fun newInstance() = Clientes()
    }

    private lateinit var viewModel: ClientesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
            token =it.getString("token").toString()
        }
        binding = FragmentClientesBinding.inflate(layoutInflater)
        return  binding.root    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClientesViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
        viewModel.descargarListaServicios(token)
    }

    private fun registrarEventos() {
        binding.btnRegresarMenu.setOnClickListener{

            val accion = ClientesDirections.actionClientesToPrincipal(token)
            findNavController().navigate(accion)
        }
    }
}