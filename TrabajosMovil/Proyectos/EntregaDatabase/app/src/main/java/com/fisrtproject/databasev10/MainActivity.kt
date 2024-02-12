package com.fisrtproject.databasev10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fisrtproject.databasev10.model.ManangerBd


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciamos la clase bd helper
        val manager = ManangerBd(this)
        val result = manager.insertData()
        val message = if (result != -1L) {
            "Datos insertados correctamente"
        } else {
            "Error al insertar datos en la base de datos"
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}