package com.example.pibja

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pibja.Activitys.AnunciosDaSemana
import com.example.pibja.Adapter.TabAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val fragmentAdapter = TabAdapter(supportFragmentManager)
        view_pager_layout_main.adapter = fragmentAdapter
        tab_layout_main.setupWithViewPager(view_pager_layout_main)
    }

    fun adicionarAnuncio(view: View) {

        val builder = AlertDialog.Builder(view.context)
        builder.setTitle("Adicionar Anuncios")
        builder.setMessage("Para adicionar novos Anuncios ou Programação percisa estar logado")
        builder.setPositiveButton("Logar", DialogInterface.OnClickListener{dialog, id ->
            Toast.makeText(this, "Ainda não configurado", Toast.LENGTH_LONG).show()
        }).setNegativeButton("Cancelar", DialogInterface.OnClickListener{dialog, id ->
        }).show()


    }


}
