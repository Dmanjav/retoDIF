package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.PrincipalViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentInicioDeSesionBinding
import mx.itesm.difood.databinding.FragmentPrincipalBinding

class Principal : Fragment() {
    private  lateinit var binding: FragmentPrincipalBinding
    companion object {
        fun newInstance() = Principal()
    }

    private lateinit var viewModel: PrincipalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrincipalViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnPedido.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarPedido()
            findNavController().navigate(accion)
        }

        binding.btnRegCliente.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarCliente()
            findNavController().navigate(accion)
        }

        binding.btnClientes.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToClientes()
            findNavController().navigate(accion)
        }

        binding.btnMenu.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarMenu()
            findNavController().navigate(accion)
        }

        binding.btnSalir.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToInicioDeSesion()
            findNavController().navigate(accion)
        }

        binding.btnAnuncio.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToAnuncio()
            findNavController().navigate(accion)
        }
    }

}