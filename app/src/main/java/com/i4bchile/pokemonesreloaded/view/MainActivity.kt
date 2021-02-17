package com.i4bchile.pokemonesreloaded.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.i4bchile.pokemonesreloaded.R
import com.i4bchile.pokemonesreloaded.databinding.ActivityMainBinding
import com.i4bchile.pokemonesreloaded.viewmodel.PokeViewModel

/**
 * [x] Control de versiones
 * [x] view binding
 *      [x] activar (build.gradle app)
 *      [] actualizar Activities y fragments con viewBinding
 * [] MainActivity
 *      [] fragment container view
 * [] consumo de API
 *      [x] permiso de internet
 *      [x] cleartext Traffic si es https
 *      [x] dependencias retrofit
 *      [x] pojos
 *      [x] interfaz de operaciones
 *      [x] cliente retrofit
 * [] ViewModel
 * [] Listado
 *      [] Fragmento de listado
 *      [] layout
 *      [] recycler view
 *      [] adapter
 *      [] Viewholder
 *      [] item layout
 *      [] enlazar las piezas
 *      [] onclick en un elemento de listado
 * [ ] detalle
 *      [] fragmento de detalle
 *      [] layout
 *      [] viewBinding
 *      [] observar la info del pokemon para detalle
 *      [] consumo de imágenes
 *
 * [ ] ROOM
 *      [] Dependencias
 *      [] Type Converters
 *      [] interfaz de operaciones (DAO)
 *      [] pojos (entities)
 *      [] cliente
 */

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Main Activity", "onCreate: ")
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_container, ListFragment())
            .addToBackStack("back").commit()
    }
}