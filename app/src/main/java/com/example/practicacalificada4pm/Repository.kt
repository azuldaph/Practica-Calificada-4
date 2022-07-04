package com.example.practicacalificada4pm

import com.example.practicacalificada4pm.network.ApiService
import com.example.practicacalificada4pm.network.PokemonResponse
import io.reactivex.Single

class Repository {
    private val api = ApiService().apiService

    fun listarPokemon(limit: Int, offset: Int): Single<PokemonResponse> {
        return api.listPokemon(limit, offset)
    }

    fun detailPokemon(name: String) {
        return api.detallePokemon(name)
    }
}