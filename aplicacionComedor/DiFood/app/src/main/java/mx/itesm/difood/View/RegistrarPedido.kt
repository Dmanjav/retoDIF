package mx.itesm.difood.View

import android.R
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning
import mx.itesm.difood.ViewModel.RegistrarPedidoViewModel
import mx.itesm.difood.databinding.FragmentRegistrarPedidoBinding
import mx.itesm.difood.model.Pedido.Pedido
/**
 * @author Carlos Alberto Sánchez Calderón
 * Vista del Registro del pedido
 */
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
        registrarObservadores()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPref = activity?.getSharedPreferences("mySharedPrefs", Context.MODE_PRIVATE)

        idMenu = sharedPref?.getString("MenuId","")
        Log.d("ApI Test","IdMenu: ${idMenu}")
        registrarEventos()
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
                binding.spnDep.selectedItem.toString(),idMenu.toString())
            viewModel.descargarListaServicios(pedidoData)

        }

        val scanner = GmsBarcodeScanning.getClient(requireContext())
        binding.btnQr.setOnClickListener{
            scanner.startScan()
                .addOnSuccessListener { barcode ->

                    val curp = barcode.rawValue.toString()
                    binding.etCliente.setText(curp)
                }
        }

        binding.btnDep.setOnClickListener{
            var url = "/app/comedor/$token/get-dependientes?curp-responsable=${binding.etCliente.text}"
            viewModel.descargarListaServicios2(url)
        }


    }

    private fun registrarObservadores() {

        //Si cambia el valor del tokenreponse te cambia de pantalla
        viewModel.tokenResponse.observe(viewLifecycleOwner){
            if(it.idPedido != "Nel"){
                val accion = RegistrarPedidoDirections.actionRegistrarPedidoToPrincipal(token)
                findNavController().navigate(accion)
            }
        }
        //si cambia el valor de clientes los despliega en pantalla
        viewModel.clientes.observe(viewLifecycleOwner){
            var arrCliente = it.toTypedArray()
            Log.d("API_Cl2",it.toString())
            val adapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item,
                arrCliente)
            adapter.setDropDownViewResource(R.layout.simple_spinner_item)
            binding.spnDep.adapter = adapter
        }
    }


}