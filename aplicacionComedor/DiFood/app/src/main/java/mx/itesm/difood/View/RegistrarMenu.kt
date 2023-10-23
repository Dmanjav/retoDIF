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
import mx.itesm.difood.ViewModel.RegistrarMenuViewModel
import mx.itesm.difood.databinding.FragmentRegistrarMenuBinding
import mx.itesm.difood.model.Menu.MenuData

/**
 * @author Carlos Alberto Sánchez Calderón
 * Vista dar de alta Menu
 */

class RegistrarMenu : Fragment() {
    private  lateinit var binding: FragmentRegistrarMenuBinding
    var token: String = ""
    companion object {
        fun newInstance() = RegistrarMenu()
    }

    private lateinit var viewModel: RegistrarMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
            token =it.getString("token").toString()
        }
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
        //Si se presiona el boton llama al API y da de alta el menu en el comedor con el que se hizo login
        binding.btnRegistrar.setOnClickListener{
            val menuData: MenuData = MenuData(token,binding.etEntrada.text.toString(),
                binding.etPlato.text.toString(),
                binding.etPostre.text.toString())
            viewModel.descargarListaServicios(menuData)
            registrarObservadores()
        }
        // te cambia de pantalla
        binding.btnReg.setOnClickListener{
            val accion = RegistrarMenuDirections.actionRegistrarMenuToPrincipal(token)
            findNavController().navigate(accion)
        }
    }

    private fun registrarObservadores() {

        //si cambia el valor del token ejecuta el token
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.token != "Nel"){
                Log.d("ApI Test","Menu: ${it.token}")

                //Guarda el menu en las preferencias
                val sharedPref = activity?.getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)
                val editor = sharedPref?.edit()
                editor?.putString("MenuId",it.token)
                editor?.apply()
                val accion = RegistrarMenuDirections.actionRegistrarMenuToPrincipal(token)
                findNavController().navigate(accion)
            }
        }
    }

}