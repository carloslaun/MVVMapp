package com.example.mvvmapp.services

import com.example.mvvmapp.model.PokemonResponse
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("pokedex.json")

    suspend fun getPokemons(): Response<PokemonResponse>

}