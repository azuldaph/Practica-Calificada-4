package com.example.practicacalificada4pm

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(){

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        val actionBar = supportActionBar
        actionBar?.hide()

        btnIngresar.setOnClickListener {
            viewModel.listarPokemon()
            viewModel.detallPokemon()
        }

        observableViewModel()
    }

    private fun observableViewModel() {

        viewModel.pokemonListResponse.observe(this) { listPokemon ->
            if (listPokemon.size > 0) {

                // adapter
                // recylerview

            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}