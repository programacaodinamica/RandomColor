package br.com.programacaodinamica.randomcolor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.programacaodinamica.randomcolor.commom.toHexCode


const val NO_NAME = "Sem nome"

@Entity(tableName = "Color")
class NamedColor(@PrimaryKey val id:Int,
                 private val _name:String?=null){
    val code: String
    get() = id.toHexCode()

    val name: String
    get() = if (_name.isNullOrBlank()) NO_NAME else _name
}