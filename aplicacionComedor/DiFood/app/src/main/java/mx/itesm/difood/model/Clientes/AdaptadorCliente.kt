package mx.itesm.difood.model.Clientes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.itesm.difood.R
import mx.itesm.difood.databinding.ClienteBinding

class AdaptadorCliente(private val contexto: Context, var arrCliente: Array<ClienteLista>)
    : RecyclerView.Adapter<AdaptadorCliente.RenglonCliente>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenglonCliente {
        val binding = ClienteBinding.inflate(LayoutInflater.from(contexto))
        return  RenglonCliente(binding.root)
    }

    override fun getItemCount(): Int {
        return arrCliente.size
    }

    override fun onBindViewHolder(holder: RenglonCliente, position: Int) {
        val cliente = arrCliente[position]
        holder.set(cliente)
    }

    class RenglonCliente(var vistaRenglon: View): RecyclerView.ViewHolder(vistaRenglon)
    {
        fun set(cliente: ClienteLista){
            vistaRenglon.findViewById<TextView>(R.id.etCliente).text = cliente.nombre
        }
    }
}