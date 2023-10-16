package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.R
import mx.itesm.difood.ViewModel.RegistrarClienteViewModel
import mx.itesm.difood.databinding.FragmentRegistrarClienteBinding
import mx.itesm.difood.model.ClienteModel.ClienteData

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
        binding.btnReturn.setOnClickListener{
            val accion = RegistrarClienteDirections.actionRegistrarClienteToPrincipal(token)
            findNavController().navigate(accion)
        }

        binding.btnCliente.setOnClickListener{
            Log.d("ApI Test","TokenCliente: $token")
            val cliente: ClienteData = ClienteData(token,binding.etCurp.text.toString(),
                binding.etNombre.text.toString(),
                binding.etApellidoP.text.toString(),
                binding.etApellidoM.text.toString(),
                binding.etFecha.text.toString(),
                binding.etCondicion.text.toString(),
                binding.etContra.text.toString())
            viewModel.descargarListaServicios(cliente)
            registrarObservadores()
        }
    }

    private fun registrarObservadores() {
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.details != "Nel"){
                val accion = RegistrarClienteDirections.actionRegistrarClienteToPrincipal(token)
                findNavController().navigate(accion)
            }
        }
    }

}