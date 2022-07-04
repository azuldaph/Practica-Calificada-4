package com.example.practicacalificada4pm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicacalificada4pm.network.Pokemon
import com.example.practicacalificada4pm.network.PokemonResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ViewModel: ViewModel() {

    private val repository = Repository()

    private val disposable = CompositeDisposable()


    val pokemonListResponse = MutableLiveData<List<Pokemon>>()

    fun listarPokemon() {
        disposable.add(
            repository.listarPokemon(10, 0)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<PokemonResponse>() {
                    override fun onSuccess(t: PokemonResponse) {

                        var listPokemones = t.results
                        pokemonListResponse.value = listPokemones
                        Log.v("POKEMON_LIST", listPokemones.toString())

                    }

                    override fun onError(e: Throwable) {
                        Log.v("RETROFIT_SERVICE", e.localizedMessage)
                    }
                })
        )
    }

    fun detallPokemon(){
            repository.detailPokemon("Balbusar")
        Log.v("POKEMON_DETAIL", PokemonResponse().toString())
    }
}