package br.com.programacaodinamica.randomcolor.commom

fun Int.toHexCode() = String.format("%06X", 0xFFFFFF and this)