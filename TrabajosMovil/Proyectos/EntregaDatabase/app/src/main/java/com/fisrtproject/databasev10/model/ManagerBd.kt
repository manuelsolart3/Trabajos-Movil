package com.fisrtproject.databasev10.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase


// Clase para manejar las operaciones de la base de datos
data class ManangerBd(val context: Context) { //creamos una instancia
    lateinit var  bd: SQLiteDatabase

    val bdhelper = Bdhelper(context)//llamando a mi conexion con mi base de datos
    //metodo para abrir la bd en modo escritura
    fun openBdwr(){

        bd = bdhelper.writableDatabase
    }

    // Método para insertar datos en la tabla de ciudades
    fun insertData():Long{
        openBdwr() // Abrir la base de datos en modo escritura

        val CityContainer = ContentValues().apply {
            put("cod", 1)
            put("nombre", "cali")
            put("coddep", 25)
            put("edad", 20)
        }
        val DataContainer = ContentValues().apply {
            put("cod", 1)
            put("nombre", "Manuel")
            put("apellido", "Solarte")
            put("telefono", "3145541115")
            put("direccion", "calle 4 # 5-30")
            put("ciudad", "popayan")
        }




        val insertCity = bd.insert("ciudad", null, CityContainer) // Insertar datos en la tabla de ciudad
        val insertData = bd.insert("carro", null, DataContainer) // Insertar datos en la tabla de datos
        bd.close()
        return insertCity // Devolver el insertCitytado de la operación de inserción







    }

}
