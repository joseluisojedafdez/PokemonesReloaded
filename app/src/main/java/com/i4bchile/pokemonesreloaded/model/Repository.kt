package com.i4bchile.pokemonesreloaded.model

import android.util.Log
import com.i4bchile.pokemonesreloaded.model.data.PokeApplication
import com.i4bchile.pokemonesreloaded.model.data.RetrofitClient


class Repository {

    private val database=PokeApplication.pokeDatabase!!
    val pokeList=database.pokeDao().getAlPokemons()

    suspend fun getPokeList(){
        Log.d("Repository", "getPokeList: ")
        val response= RetrofitClient.retrofitInstance().getPokemones()
        Log.d("Repository", "getPokeList: ${response.code()}")
        when (response.isSuccessful){

            true -> {
                Log.d("Remote", "getPokeList: List obtained with ${response.body()?.size} elements")
                response.body()?.let{database.pokeDao().loadAllPokemons(it)}

            }
            false -> {
                Log.d("Remote", "getPokeList: Connection Error: Code ${response.code()}")
            }


        }


    }


}