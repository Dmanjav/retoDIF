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
        binding.btnRegistrar.setOnClickListener{
            val menuData: MenuData = MenuData(token,binding.etEntrada.text.toString(),
                binding.etPlato.text.toString(),
                binding.etPostre.text.toString())
            viewModel.descargarListaServicios(menuData)
            registrarObservadores()
        }
        binding.btnReg.setOnClickListener{
            val accion = RegistrarMenuDirections.actionRegistrarMenuToPrincipal(token)
            findNavController().navigate(accion)
        }
    }

    private fun registrarObservadores() {
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.token != "Nel"){
                Log.d("ApI Test","Menu: ${it.token}")

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