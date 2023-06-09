package com.example.pokemon

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemon.databinding.ItemRecyclerBinding
import com.example.pokemon.model.Result

class MainAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var pokemons = mutableListOf<Result>()
    @SuppressLint("NotifyDataSetChanged")
    fun setPokemonList(movies: List<Result>) {
        this.pokemons = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.binding.itemName.text = pokemon.name
       // Glide.with(holder.itemView.context).load(pokemon.url).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return pokemons.size
    }
}
class MainViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
}