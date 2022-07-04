package com.example.practicacalificada4pm.network

import io.reactivex.Single
import retrofit2.http.*

interface TecsupApi {

    // https://pokeapi.co/api/v2/pokemon?limit=100&offset=0
    @GET("api/v2/pokemon")
    fun listPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int): Single<PokemonResponse>

    // https://pokeapi.co/api/v2/pokemon/ditto
    @GET("api/v2/pokemon/{nombre}")
    fun detallePokemon(@Path("nombre") nombre: String)

}