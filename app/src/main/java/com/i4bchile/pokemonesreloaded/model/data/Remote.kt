package com.i4bchile.pokemonesreloaded.model.data

import com.i4bchile.pokemonesreloaded.model.PokeDetail
import com.i4bchile.pokemonesreloaded.model.Pokemon
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeAPI {
    @GET("pokemon")
    suspend fun getPokemones(): Response<List<Pokemon>>

    @GET("pokemon/{pid}")
    suspend fun getPokemon(@Path("pid") id: Int): Response<PokeDetail>
}

class RetrofitClient {
    companion object {
        private const val BASE_URL =  "https://lapi-pokemon.herokuapp.com/"

        fun retrofitInstance(): PokeAPI {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create())
                    .build()

            return retrofit.create(PokeAPI::class.java)
        }
    }
}

