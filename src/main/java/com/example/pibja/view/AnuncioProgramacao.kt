package com.example.pibja.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.pibja.Async.DownloadImagem
import com.example.pibja.R
import kotlinx.android.synthetic.main.activity_anuncio_programacao.*

class AnuncioProgramacao : AppCompatActivity() {

    var showInOut = 1
    lateinit var layoutInformation: LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anuncio_programacao)
        setSupportActionBar(toolbar_anun_prog as androidx.appcompat.widget.Toolbar?)
        toolbarBuilder()


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

    private fun toolbarBuilder() {
        val actionBar = supportActionBar
        actionBar!!.setIcon(R.drawable.ic_voltar)
        actionBar.title = ""
        actionBar.elevation = 4.0f
        actionBar.setDisplayShowHomeEnabled(true)

    }


    fun showInOrShowOut() {
        val animationIn = AnimationUtils.loadAnimation(applicationContext, R.anim.slice_down)
        val animationOut = AnimationUtils.loadAnimation(applicationContext, R.anim.slice_in)
        val rodarImgemCima = AnimationUtils.loadAnimation(applicationContext, R.anim.rotate)
        layoutInformation.visibility = View.VISIBLE

        if(showInOut == 1){
            //textView.text = "ver menos"
            //view.startAnimation(animationIn)
            Toast.makeText(applicationContext, "Show in", Toast.LENGTH_SHORT).show()
            layoutInformation.startAnimation(animationIn)
            showInOut = 0
        }else{
            //textView.text = "ver mais"
           // view.startAnimation(animationOut)
            Toast.makeText(applicationContext, "Show out", Toast.LENGTH_SHORT).show()
            layoutInformation.startAnimation(animationOut)
            showInOut = 1
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_anun_prog, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.compartilhar_anun_prog ->{
                return true
            }
            R.id.ver_mais->{
                showInOrShowOut()
                return true
            }


        }

        return super.onOptionsItemSelected(item)
    }
}
