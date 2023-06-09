package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.databinding.ActivityMainBinding
import com.example.pokemon.viewmodel.MainViewModel
import com.example.pokemon.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(
            this,
            MyViewModelFactory(MainRepository(retrofitService))
        )[MainViewModel::class.java]
        binding.recyclerActivity.layoutManager = LinearLayoutManager(this)
        binding.recyclerActivity.adapter = adapter
        viewModel.pokemonList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setPokemonList(it.results)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
    }
}