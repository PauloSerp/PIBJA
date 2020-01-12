package com.example.pibja

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pibja.Async.DownloadImagem

class AnuncioProgramacao : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncio_programacao)

        //val bundle: Bundle ?= intent.extras
        //var data1 = bundle!!.getString("data")
        //var imagem1 = bundle.getString("imagem")

        val data: String = intent.getStringExtra("DATA")
        val imagem: String = this.intent.getStringExtra("IMG")

        Log.i("Anuncios", "$data, $imagem")

        val imageView: ImageView = findViewById(R.id.banner_anuncios_programacao)
        val dataView: TextView = findViewById(R.id.data_prog_anun)
        val progressBar: ProgressBar = findViewById(R.id.progress_anun_prog)


        DownloadImagem(imageView, progressBar).execute(imagem)

        dataView.text = data


    }
}
