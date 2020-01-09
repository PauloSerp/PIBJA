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
import com.example.pibja.Utils.Anuncios
import com.example.pibja.Async.DownloadImagem
import com.example.pibja.R

class AnunciosAdapter (val listsaDeAnuncios: ArrayList<Anuncios>, val context: Context): RecyclerView.Adapter<AnunciosAdapter.AnunciosViewHolder>(){

    class AnunciosViewHolder(view: View): RecyclerView.ViewHolder(view){

        val titulo = view.findViewById(R.id.titulo_evento_anuncios) as TextView
        val data = view.findViewById(R.id.data_evento_anuncios) as TextView
        val imagem = view.findViewById(R.id.imagem_evento_anuncios) as ImageView
        val descricao = view.findViewById(R.id.descricao_evento_anuncios) as TextView
        val cardView = view.findViewById(R.id.card_view_anuncios) as CardView
        val progressBar = view.findViewById(R.id.progressBarId) as ProgressBar

    }

    //infla o componente
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnunciosViewHolder {
        val viewAnuncios = LayoutInflater.from(parent.context).inflate(R.layout.itens_lista, parent, false)

        return AnunciosViewHolder(viewAnuncios)
    }


    override fun onBindViewHolder(holder: AnunciosViewHolder, position: Int) {
        holder.titulo.text = listsaDeAnuncios[position].titulo
        holder.data.text = listsaDeAnuncios[position].data
        holder.descricao.text = listsaDeAnuncios[position].descricao

        DownloadImagem(holder.imagem, holder.progressBar).execute(listsaDeAnuncios[position].imagem)

        holder.cardView.setOnClickListener {
            val builder = AlertDialog.Builder(context)
            builder.setTitle("${holder.titulo.text}")
            builder.setMessage("${holder.descricao.text}")
            builder.show()
        }

    }

    override fun getItemCount(): Int = listsaDeAnuncios.size

}