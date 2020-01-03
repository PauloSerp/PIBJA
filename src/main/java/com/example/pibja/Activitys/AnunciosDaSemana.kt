package com.example.pibja.Activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pibja.Utils.Anuncios
import com.example.pibja.Adapter.AnunciosAdapter
import com.example.pibja.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.firestore.FirebaseFirestore


class AnunciosDaSemana : AppCompatActivity() {

    lateinit var myAd: AdView
    lateinit var listView: RecyclerView
    lateinit var adapter: RecyclerView.Adapter<AnunciosAdapter.AnunciosViewHolder>
    var listaAnuncios = ArrayList<Anuncios>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncios_da_semana)


        //inicializa addMods
        MobileAds.initialize(this, "ca-app-pub-3858504858329360~2430581785")
        listView= findViewById(R.id.recycle_view_anuncios)
        myAd = findViewById(R.id.adView)
        val adRequest: AdRequest = AdRequest.Builder().build()
        myAd.loadAd(adRequest)
        requisicaoFirebase()

    }

    private fun requisicaoFirebase() {

        val firebaseFirestore = FirebaseFirestore.getInstance()

        firebaseFirestore.collection("anuncios").orderBy("peso").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    listaAnuncios.add(
                        Anuncios(
                            "${document.get("titulo")}",
                            "${document.get("data")}",
                            "${document.get("imagem")}",
                            "${document.get("descricao")}"
                        )
                    )



                }
                populaListaAnuncios(listaAnuncios)
            }

    }

    fun populaListaAnuncios(listaAnuncios: ArrayList<Anuncios>){
    this.listaAnuncios = listaAnuncios
    val layout = LinearLayoutManager(this)
    listView.layoutManager = layout
    adapter = AnunciosAdapter(listaAnuncios, this)
    listView.adapter = adapter
        val progress: ProgressBar = findViewById(R.id.progressBarMain)
        progress.visibility = View.GONE
}
}


