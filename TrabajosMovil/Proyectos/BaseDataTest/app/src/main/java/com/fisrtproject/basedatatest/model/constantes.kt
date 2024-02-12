package com.fisrtproject.basedatatest.model

// Definición de las constantes globales de la base de datos
class constantes {
    //sirve para que las constantes sean globales
    companion object {
        const val NOM_BD = "BdAdso" //nombre de la base de datos
        const val VERSION_BD = 11// Versión de la base de datos
        const val TABLA = "create table ciudad (cod int, nombre text, coddep int)" // Versión de la base de datos para crear las tablas
        const val TABLA2 = "create table datos (cod int,nombre text,apellido  text,telefono  int,direccion text,ciudad text)"
        const val DATA = "SELECT * FROM ciudad)"
    }}