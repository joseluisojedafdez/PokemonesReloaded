package com.i4bchile.pokemonesreloaded.model

import android.util.Log
import com.i4bchile.pokemonesreloaded.model.data.RetrofitClient


class Repository {

    suspend fun getPokeList(){
        Log.d("Repository", "getPokeList: ")
        val response= RetrofitClient.retrofitInstance().getPokemones()
        Log.d("Repository", "getPokeList: ${response.code()}")
        when (response.isSuccessful){

            true -> {
                Log.d("Remote", "getPokeList: List obtained with ${response.body()?.size} elements")

            }
            false -> {
                Log.d("Remote", "getPokeList: Connection Error: Code ${response.code()}")
            }


        }


    }


}