package br.com.programacaodinamica.randomcolor

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SavedColorsViewModel : ViewModel() {

    val randomColor = MutableLiveData<Int>().apply { value = 0 }

}
