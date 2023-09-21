package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.InicioDeSesionViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentInicioDeSesionBinding

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
        binding.btnInicio.setOnClickListener{

            val accion = InicioDeSesionDirections.actionInicioDeSesionToPrincipal()
            findNavController().navigate(accion)
        }
    }

}