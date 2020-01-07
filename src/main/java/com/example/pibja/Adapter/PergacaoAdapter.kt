package com.example.pibja.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pibja.Async.DownloadImagem
import com.example.pibja.R
import com.example.pibja.Utils.Programacao

class ProgramacaoAdapter(val listaDeProgramacao: ArrayList<Programacao>, val context: Context):
        RecyclerView.Adapter<ProgramacaoAdapter.ProgramacaoViewHolder>(){


    class ProgramacaoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val titulo = view.findViewById(R.id.titulo_evento_anuncios) as TextView
        val data = view.findViewById(R.id.data_evento_anuncios) as TextView
        val imagem = view.findViewById(R.id.imagem_evento_anuncios) as ImageView
        val descricao = view.findViewById(R.id.descricao_evento_anuncios) as TextView
        val cardView = view.findViewById(R.id.card_view_anuncios) as CardView
        val progressBar = view.findViewById(R.id.progressBarId) as ProgressBar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramacaoViewHolder {
        val viewProgramacao = LayoutInflater.from(parent.context).inflate(R.layout.itens_lista, parent, false)
        return ProgramacaoViewHolder(viewProgramacao)
    }

    override fun getItemCount(): Int = listaDeProgramacao.size

    override fun onBindViewHolder(holder: ProgramacaoViewHolder, position: Int) {

        holder.data.text = listaDeProgramacao[position].data
        holder.titulo.text = listaDeProgramacao[position].titulo
        holder.descricao.text = listaDeProgramacao[position].descricao

        DownloadImagem(holder.imagem, holder.progressBar).execute(listaDeProgramacao[position].imagem)
        holder.cardView.setOnClickListener{
            val builder = AlertDialog.Builder(context)
            builder.setTitle("${holder.titulo}")
            builder.setMessage("${holder.descricao.text}")
            builder.show()
        }

    }


}