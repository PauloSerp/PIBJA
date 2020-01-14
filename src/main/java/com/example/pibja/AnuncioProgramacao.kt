package com.example.pibja

import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pibja.Async.DownloadImagem
import kotlinx.android.synthetic.main.activity_anuncio_programacao.*

class AnuncioProgramacao : AppCompatActivity() {

    var showInOut = 1
    lateinit var layoutInformation: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncio_programacao)


        val data: String = intent.getStringExtra("DATA")
        val imagem: String = intent.getStringExtra("IMG")
        val hora: String = intent.getStringExtra("HORA")
        val local: String = intent.getStringExtra("LOCAL")

        Log.i("Anuncios", "$data, $imagem")

        val imageView: ImageView = findViewById(R.id.banner_anuncios_programacao)
        val dataView: TextView = findViewById(R.id.data_prog_anun)
        val progressBar: ProgressBar = findViewById(R.id.progress_anun_prog)
        val localView: TextView = findViewById(R.id.local_anun_prog)
        val horaView: TextView = findViewById(R.id.hora_anun_prog)
        layoutInformation = findViewById(R.id.linearLayoutAnunProg)


        val animationOut = AnimationUtils.loadAnimation(applicationContext, R.anim.slice_in)
        layoutInformation.visibility = View.GONE
        layoutInformation.startAnimation(animationOut)
        DownloadImagem(imageView, progressBar).execute(imagem)

        dataView.text = data
        localView.text = local
        horaView.text = hora


    }

    fun showInOrShowOut(view: View) {
        val animationIn = AnimationUtils.loadAnimation(applicationContext, R.anim.slice_down)
        val animationOut = AnimationUtils.loadAnimation(applicationContext, R.anim.slice_in)
        val rodarImgemCima = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
        val textView: TextView = findViewById(R.id.button_ver_mais)
        layoutInformation.visibility = View.VISIBLE

        if(showInOut == 1){
            textView.text = "ver menos"
            //view.startAnimation(animationIn)
            layoutInformation.startAnimation(animationIn)
            showInOut = 0
        }else{
            textView.text = "ver mais"
           // view.startAnimation(animationOut)
            layoutInformation.startAnimation(animationOut)
            showInOut = 1
        }
    }
}
