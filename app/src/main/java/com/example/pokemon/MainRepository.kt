package com.example.pokemon

import com.example.pokemon.model.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllPokemon(): Response<PokemonResponse>
    {
        return withContext(Dispatchers.IO){
            retrofitService.getAllPokemon()
        }
    }
}