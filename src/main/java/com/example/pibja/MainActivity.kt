package com.example.pibja

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pibja.Activitys.AnunciosDaSemana

class MainActivity : AppCompatActivity() {
    var fragmentManager = supportFragmentManager
    var fragmentTransacion = fragmentManager.beginTransaction()
    var fragmentAnuncios= AnunciosDaSemana()
    var fragmentProgramacao = ProgramacaoMes()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        inicializaComp()
    }

    private fun inicializaComp() {

    }
}
