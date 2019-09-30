package br.com.programacaodinamica.randomcolor.model

import br.com.programacaodinamica.randomcolor.commom.toHexCode


const val NO_NAME = "Sem nome"

class NamedColor(val id:Int,
                 val _name:String?=null){
    val code: String
    get() = id.toHexCode()

    val name: String
    get() = _name ?: NO_NAME
}