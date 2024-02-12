package com.fisrtproject.myapplication.data

import android.content.Context
import android.content.SharedPreferences
import java.lang.IllegalArgumentException
import java.security.Key
import java.security.KeyRep

class sharedPreferencesManager (private var context:Context){
//Configuramos el shared


    //CREAMOS UNA VARIABLE PARA EL NOMBRE DE BD
    private val nameDB="My_Data_Base"

//Para generar una instancia o hacer una carga lenta con by lazy
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences( "nameDB", Context.MODE_PRIVATE)

    }


//Creamos un pequeño CRUD
    fun saveUser(user: String){
        val editor= sharedPreferences.edit()
    //Guardamos un valor tipo string donde nos pide dos parametros la llave y el valor
        editor.putString("KeyUSer",user)
    //aplicamos los cambios
        editor.apply()


    }
//Creamos una funcion para obtener los elementos de la BD
    fun getuser():String{
    //le entregamos la clave y el valor predeterminado
      return sharedPreferences.getString("KeyUser", "Empty").toString()

    }

fun getuserloged():Boolean{
    return sharedPreferences.getBoolean("miBoolean" , false)


}fun removesharedP(Key: String){
   val editor = sharedPreferences.edit()
        editor.remove(Key)
        editor.apply()



}



    //SOLUCION A POSIBLE PROBLEMA DE ESCALABILIDAD para no repetir esto

    fun savePref ( Key: String, value:Any   ){
        val editor = sharedPreferences.edit()
        //switch es = when
        //creamos casos para evaluar el tipo de dato del valor del input
        when(value){
          is String -> editor.putString(Key,value)
          is Int -> editor.putInt(Key, value)
          is Boolean -> editor.putBoolean(Key, value)
          is Float -> editor.putFloat(Key, value)
          is Long -> editor.putLong(Key, value)
            else -> throw IllegalArgumentException ("Este valor no es valido")
        }
editor.apply()

    }

    fun getPref(Key: String,defaultValue: Any){
        val sharedPreferences= context.getSharedPreferences( "nameDB", Context.MODE_PRIVATE)
        when(defaultValue){
            is String -> sharedPreferences.getString(Key, defaultValue)
            is Int -> sharedPreferences.getInt(Key, defaultValue)
            is Boolean -> sharedPreferences.getBoolean(Key, defaultValue)
            is Float -> sharedPreferences.getFloat(Key, defaultValue)
            is Long -> sharedPreferences.getLong(Key, defaultValue)
            else -> IllegalArgumentException("No se encontro en la base de Datos")
        }


    }





}
