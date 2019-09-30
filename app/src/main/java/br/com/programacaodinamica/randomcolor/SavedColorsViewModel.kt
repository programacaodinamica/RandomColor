package br.com.programacaodinamica.randomcolor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.programacaodinamica.randomcolor.database.ColorDatabase
import br.com.programacaodinamica.randomcolor.database.ColorRepository
import br.com.programacaodinamica.randomcolor.model.NamedColor

class SavedColorsViewModel(application: Application):
                    AndroidViewModel(application) {

    val randomColor = MutableLiveData<Int>().apply { value = 0 }
    private val colorRepository: ColorRepository
    var colors:LiveData<List<NamedColor>>

    init {
        val database = ColorDatabase.get(application.applicationContext)
        colorRepository = ColorRepository(database.colorDAO())
        colors = colorRepository.allColors()
    }

    fun saveColor(color: NamedColor){
        colorRepository.insert(color)
    }

}
