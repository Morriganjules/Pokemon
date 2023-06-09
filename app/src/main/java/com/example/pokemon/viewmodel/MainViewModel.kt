package com.example.pokemon.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemon.MainRepository
import com.example.pokemon.model.PokemonResponse
import kotlinx.coroutines.launch

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val pokemonList = MutableLiveData<PokemonResponse>()
    val errorMessage = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            val response = repository.getAllPokemon()
            pokemonList.postValue(response.body())
        }
    }
}