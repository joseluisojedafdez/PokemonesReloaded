package com.i4bchile.pokemonesreloaded.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.i4bchile.pokemonesreloaded.model.PokeDetail
import com.i4bchile.pokemonesreloaded.model.Repository
import kotlinx.coroutines.launch

class PokeViewModel: ViewModel() {


    private val repository = Repository()
    val pokeList = repository.pokeList
    private val pokeDetail = MutableLiveData<PokeDetail>()
    fun getPokeDetail(): LiveData<PokeDetail> {
        return pokeDetail
    }

    fun getPokeDetails(pokeId: Int) {
        viewModelScope.launch {
            pokeDetail.value = repository.getPokeDetail(pokeId)
        }

    }

        init {
            viewModelScope.launch {
                Log.d("initiate ViewModel", ": obteniendo lista Pokemones")
                repository.getPokeList()
            }


        }


    }
