package com.example.pibja.Activitys

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pibja.Adapter.ProgramacaoAdapter
import com.example.pibja.R
import com.example.pibja.Utils.Programacao
import com.google.firebase.firestore.FirebaseFirestore

class ProgramacaoMes: Fragment() {
    lateinit var listView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<ProgramacaoAdapter.ProgramacaoViewHolder>
    var listaProgramacao = ArrayList<Programacao>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View
        view = inflater.inflate(R.layout.activity_programacao_mes, container, false)
        requisicaoFirebase(context, view)
        return view
    }

    private fun requisicaoFirebase(context: Context?,view: View){
        val firebaseFirestore = FirebaseFirestore.getInstance()
        firebaseFirestore.collection("programacao").orderBy("peso").get()
                .addOnSuccessListener{result ->
                    for (document in result){

                        listaProgramacao.add(Programacao(
                                "${document.get("titulo")}",
                                "${document.get("data")}",
                                "${document.get("imagem")}",
                                "${document.get("descricao")}"))

                    }
                    if (context != null){
                        populaListaProgramacao(listaProgramacao, context, view)
                    }

                }
    }

    private fun populaListaProgramacao(listaProgramacao: ArrayList<Programacao>, context: Context, view: View) {
        this.listaProgramacao = listaProgramacao
        val layout = LinearLayoutManager(context)

        listView = view.findViewById(R.id.recycle_view_programacao)
        listView.layoutManager = layout
        adapter = ProgramacaoAdapter(listaProgramacao, context)
        listView.adapter = adapter
        val progress: ProgressBar = view.findViewById(R.id.progressBarProgramacaoMes)
        progress.visibility = View.GONE

    }

}
