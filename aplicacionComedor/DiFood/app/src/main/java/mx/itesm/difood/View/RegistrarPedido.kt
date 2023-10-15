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
import mx.itesm.difood.model.Pedido

class RegistrarPedido : Fragment() {
    private lateinit var binding: FragmentRegistrarPedidoBinding
    var token: String = ""
    companion object {
        fun newInstance() = RegistrarPedido()
    }

    private lateinit var viewModel: RegistrarPedidoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
            token =it.getString("token").toString()
        }
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

            val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal(token)
            findNavController().navigate(accion)
        }

        binding.btnEnvPedido.setOnClickListener{
            val pedidoData: Pedido = Pedido(token,"1","SACC030606HMCNLRA2",
                "SACC030606HMCNLRA2","1" )
            viewModel.descargarListaServicios(pedidoData)
            registrarObservadores()
        }
    }

    private fun registrarObservadores() {
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.token != "Nel"){
                val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal(token)
                findNavController().navigate(accion)
            }
        }
    }


}