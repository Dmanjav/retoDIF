package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.R
import mx.itesm.difood.ViewModel.RegistrarPedidoViewModel
import mx.itesm.difood.databinding.FragmentRegistrarPedidoBinding

class RegistrarPedido : Fragment() {
    private lateinit var binding: FragmentRegistrarPedidoBinding
    companion object {
        fun newInstance() = RegistrarPedido()
    }

    private lateinit var viewModel: RegistrarPedidoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrarPedidoBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrarPedidoViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnRegresar.setOnClickListener{

            val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal()
            findNavController().navigate(accion)
        }
    }

}