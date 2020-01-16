@file:Suppress("DEPRECATION")

package com.example.pibja.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pibja.view.AnunciosDaSemana
import com.example.pibja.view.ProgramacaoMes

class TabAdapter(fragmentManeger: FragmentManager): FragmentPagerAdapter(fragmentManeger){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                AnunciosDaSemana()
            }
            else -> {
                ProgramacaoMes()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Anuncios"
            else -> "Programação"

        }
    }
}