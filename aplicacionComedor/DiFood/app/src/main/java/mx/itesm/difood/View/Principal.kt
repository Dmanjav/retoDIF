package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.PrincipalViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentInicioDeSesionBinding
import mx.itesm.difood.databinding.FragmentPrincipalBinding
/**
 * @author Carlos Alberto Sánchez Calderón
 * Vista del fragmento Principal
 */
class Principal : Fragment() {
    private  lateinit var binding: FragmentPrincipalBinding
    var token:String = ""

    companion object {
        fun newInstance() = Principal()
    }

    private lateinit var viewModel: PrincipalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
            token =it.getString("token").toString()
            Log.d("ApI Test", "uwu: $token")
        }
        binding = FragmentPrincipalBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PrincipalViewModel::class.java)
        //Se hace el endpoint para la llamada del API
        val endpoint = "app/comedor/$token/get-donaciones-dia"
        viewModel.descargarListaServicios(endpoint)
        registrarObservadores()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()

    }

    private fun registrarObservadores() {
        //Si hay cambios en la variable donaciones se ejecuta el codigo
        viewModel.donaciones.observe(viewLifecycleOwner){
            if(it.donaciones != "Nel"){
                //Muestra las donaciones que hay en ese momento
                binding.etDon.text = it.noDonaciones
            }
        }
    }

    private fun registrarEventos() {
        //Aqui depende del boton que es presionado se cambia de fragmento
        binding.btnPedido.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarPedido(token)
            findNavController().navigate(accion)
        }

        binding.btnRegCliente.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarCliente(token)
            findNavController().navigate(accion)
        }

        binding.btnClientes.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToClientes(token)
            findNavController().navigate(accion)
        }

        binding.btnMenu.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToRegistrarMenu(token)
            findNavController().navigate(accion)
        }

        binding.btnSalir.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToInicioDeSesion()
            findNavController().navigate(accion)
        }

        binding.btnAnuncio.setOnClickListener{
            val accion = PrincipalDirections.actionPrincipalToAnuncio(token)
            findNavController().navigate(accion)
        }

    }

}