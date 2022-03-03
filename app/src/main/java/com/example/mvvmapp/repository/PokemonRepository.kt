package com.example.mvvmapp.repository

import com.example.mvvmapp.services.RetrofitClient
import com.example.mvvmapp.services.WebService

class PokemonRepository{
    private var apiService: WebService? = null

    init{
        apiService = RetrofitClient.getClient?.create(WebService::class.java)
    }


    suspend fun getPokemon() = apiService?.getPokemons()

}