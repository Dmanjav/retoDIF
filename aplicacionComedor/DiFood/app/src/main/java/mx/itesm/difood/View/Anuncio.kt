package mx.itesm.difood.View

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import mx.itesm.difood.ViewModel.AnuncioViewModel
import mx.itesm.difood.R
import mx.itesm.difood.databinding.FragmentAnuncioBinding
import mx.itesm.difood.databinding.FragmentPrincipalBinding

class Anuncio : Fragment() {
    private  lateinit var binding: FragmentAnuncioBinding
    companion object {
        fun newInstance() = Anuncio()
    }

    private lateinit var viewModel: AnuncioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnuncioBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnuncioViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnRegresarAnuncio.setOnClickListener{
            val accion = AnuncioDirections.actionAnuncioToPrincipal()
            findNavController().navigate(accion)
        }


    }

}