package com.example.pibja.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pibja.Utils.Anuncios
import com.example.pibja.Adapter.AnunciosAdapter
import com.example.pibja.R
import com.google.firebase.firestore.FirebaseFirestore


class AnunciosDaSemana :Fragment(){

    lateinit var listView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<AnunciosAdapter.AnunciosViewHolder>
    var listaAnuncios = ArrayList<Anuncios>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View
        view = inflater.inflate(R.layout.activity_anuncios_da_semana, container, false)
        requisicaoFirebase(context, view)
        return view
    }

    private fun requisicaoFirebase(context: Context?, view: View) {

        val firebaseFirestore = FirebaseFirestore.getInstance()

        firebaseFirestore.collection("anuncios").orderBy("peso").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listaAnuncios.add(
                        Anuncios(
                            "${document.get("titulo")}",
                            "${document.get("data")}",
                             "${document.get("imagem")}",
                            "${document.get("descricao")}",
                                "${document.get("local")}",
                                "${document.get("hora")}")
                    )
                }
                if (context != null) {
                    populaListaAnuncios(listaAnuncios, context, view)
                }
            }

    }

    fun populaListaAnuncios(listaAnuncios: ArrayList<Anuncios>, context: Context, view: View){
    this.listaAnuncios = listaAnuncios
    val layout = LinearLayoutManager(context)

    listView = view.findViewById(R.id.recycle_view_anuncios)
    listView.layoutManager = layout
    adapter = AnunciosAdapter(listaAnuncios, context)
    listView.adapter = adapter
        val progress: ProgressBar = view.findViewById(R.id.progressBarMain)
        progress.visibility = View.GONE
    }
}


