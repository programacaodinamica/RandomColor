package br.com.programacaodinamica.randomcolor.commom

import android.graphics.Color


fun generateRandomColor(): Int{
    fun randomByte() = (0..255).random()
    return Color.rgb(randomByte(), randomByte(), randomByte())
}