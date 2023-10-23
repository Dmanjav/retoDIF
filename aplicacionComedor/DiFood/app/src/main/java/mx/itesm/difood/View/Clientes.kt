package mx.itesm.difood.View

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import mx.itesm.difood.ViewModel.ClientesViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentClientesBinding
import mx.itesm.difood.model.Clientes.AdaptadorCliente
/**
 * @author Carlos Alberto Sánchez Calderón
 * Vista del fragmento Clientes
 */

class Clientes : Fragment() {
    private lateinit var binding: FragmentClientesBinding
    var token:String = ""
    private  var adaptadorCliente: AdaptadorCliente? = null

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

        // Se crea el endpoint para la llamada a la api
        val endpoint = "app/comedor/$token/get-clientes"
        Log.d("ApI Clientes",endpoint)
        registrarEventos()
        //Llamada a la API
        viewModel.descargarListaServicios(endpoint)
        registrarObservadores()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun registrarObservadores() {
        //Si cambia el valor de clientes ejecuta el codigo
        viewModel.clientes.observe(viewLifecycleOwner){
            //Crea y muestra el arrreglo con la informacion recibida
            var arrCliente = it.toTypedArray()
            Log.d("API_Cl",it.toString())
            val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,
                arrCliente)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            binding.spinner.adapter = adapter






        }
    }

    private fun registrarEventos() {
        binding.btnRegresarMenu.setOnClickListener{

            val accion = ClientesDirections.actionClientesToPrincipal(token)
            findNavController().navigate(accion)
        }
    }
}