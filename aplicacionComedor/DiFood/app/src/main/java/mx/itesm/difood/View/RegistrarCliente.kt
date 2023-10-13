package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.R
import mx.itesm.difood.ViewModel.RegistrarClienteViewModel
import mx.itesm.difood.databinding.FragmentRegistrarClienteBinding

class RegistrarCliente : Fragment() {
    private  lateinit var binding: FragmentRegistrarClienteBinding
    var token:String = ""
    companion object {
        fun newInstance() = RegistrarCliente()
    }

    private lateinit var viewModel: RegistrarClienteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
            token =it.getString("token").toString()
        }
        binding = FragmentRegistrarClienteBinding.inflate(layoutInflater)
        return  binding.root    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrarClienteViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnCliente.setOnClickListener{
            val accion = RegistrarClienteDirections.actionRegistrarClienteToPrincipal(token)
            findNavController().navigate(accion)
        }
    }

}