package br.com.programacaodinamica.randomcolor.database

import androidx.lifecycle.LiveData
import br.com.programacaodinamica.randomcolor.model.NamedColor

class ColorRepository(private val colorDAO: NamedColorDAO) {

    fun allColors(): LiveData<List<NamedColor>>{
        return colorDAO.allColors()
    }

    fun insert(color: NamedColor){
        colorDAO.insert(color)
    }
}