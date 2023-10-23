package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.InicioDeSesionViewModel
import mx.itesm.difood.databinding.FragmentInicioDeSesionBinding
import mx.itesm.difood.model.InicioSesion.InicioSesionPost
/**
 * @author Carlos Alberto Sánchez Calderón
 * Vista del Inicio de Sesion
 */

class InicioDeSesion : Fragment() {
    private  lateinit var binding: FragmentInicioDeSesionBinding

    companion object {
        fun newInstance() = InicioDeSesion()
    }

    private lateinit var viewModel: InicioDeSesionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioDeSesionBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InicioDeSesionViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        // si presionan el boton ejecuta el codigo
        binding.btnInicio.setOnClickListener{
            //Cinco de Mayo
            binding.btnInicio.isEnabled = false
            //Toma los valores de los campos de texto
            val sucursal:String = binding.etSucursal.text.toString()
            val contraseña: String = binding.etContraseA.text.toString()
            val inicioSesionData: InicioSesionPost = InicioSesionPost(sucursal,contraseña)

            //Se hace la llamada a la API
            viewModel.descargarListaServicios(inicioSesionData)
            registrarObservadores()

        }
    }

    fun registrarObservadores(){
        //Si hay cambios en el valor del token se ejecuta el codigo
        viewModel.token.observe(viewLifecycleOwner){variable ->
            if (variable.token != "Nel"){
                binding.btnInicio.isEnabled = true
                val accion = InicioDeSesionDirections.actionInicioDeSesionToPrincipal(variable.token)
                findNavController().navigate(accion)
            }
        }
    }

}