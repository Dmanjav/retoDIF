package mx.itesm.difood.View

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.RegistrarPedidoViewModel
import mx.itesm.difood.databinding.FragmentRegistrarPedidoBinding
import mx.itesm.difood.model.Pedido.Pedido

class RegistrarPedido : Fragment() {
    private lateinit var binding: FragmentRegistrarPedidoBinding
    var token: String = ""
    var idMenu: String? = ""
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
        val sharedPref = activity?.getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)

        idMenu = sharedPref?.getString("MenuId","")
        Log.d("ApI Test","IdMenu: ${idMenu}")
    }

    private fun registrarEventos() {
        binding.btnRegresar.setOnClickListener{

            val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal(token)
            findNavController().navigate(accion)
        }

        binding.btnEnvPedido.setOnClickListener{
            val donacion: String
            if(binding.cbDonacion.isChecked){
                donacion = "1"
            }else{
                donacion = "0"
            }
            val pedidoData: Pedido = Pedido(token,donacion, binding.etCliente.text.toString(),
                binding.etDependiente.text.toString(),idMenu.toString())
            viewModel.descargarListaServicios(pedidoData)
            registrarObservadores()
        }
    }

    private fun registrarObservadores() {
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.idPedido != "Nel"){
                val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal(token)
                findNavController().navigate(accion)
            }
        }
    }


}