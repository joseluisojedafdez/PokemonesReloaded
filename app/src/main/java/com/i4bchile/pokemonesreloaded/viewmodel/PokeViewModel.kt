package com.i4bchile.pokemonesreloaded.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.pokemonesreloaded.model.Repository
import kotlinx.coroutines.launch

class PokeViewModel: ViewModel() {

    private val repository= Repository()
    val pokeList=repository.pokeList

    fun doSomethig(){
        Log.d("initiate ViewModel", "doSomethig: ")}
    init{
               viewModelScope.launch{
                   Log.d("initiate ViewModel", ": obteniendo lista Pokemones")
               repository.getPokeList()
            }


    }


}