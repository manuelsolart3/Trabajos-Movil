package com.jhon.basedatoszulema.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.SyncStateContract.Constants


// Clase para ayudar en la creación y actualización de la base de datos
class Bdhelper(
    context: Context?,
) : SQLiteOpenHelper(context, constantes.NOM_BD , null, constantes.VERSION_BD) {
    //extender de la clase sqliteOpenHelper:
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL(constantes.TABLA)
        db?.execSQL(constantes.TABLA2)




    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
     db?.execSQL("DROP TABLE IF EXISTS ciudad")
        onCreate(db)

    }

}