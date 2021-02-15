package com.i4bchile.pokemonesreloaded.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.i4bchile.pokemonesreloaded.databinding.ItemListBinding
import com.i4bchile.pokemonesreloaded.model.Pokemon

class PokeAdapter:RecyclerView.Adapter<PokeVH>() {

    private var pokeList=listOf<Pokemon>()
    private val selectedItem= MutableLiveData<Pokemon>()

    fun getSelected(): LiveData<Pokemon> {
        return selectedItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeVH {
        val binding=ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return PokeVH(binding)
    }

    override fun onBindViewHolder(holder: PokeVH, position: Int) {
        val pokemon=pokeList[position]
        holder.itemView.setOnClickListener{
            selectedItem.value=pokemon
        }
        holder.bind(pokemon)
    }

    override fun getItemCount()=pokeList.size

    fun update(list: List<Pokemon>) {
        pokeList=list
        notifyDataSetChanged()

    }
}

class PokeVH (val binding:ItemListBinding):RecyclerView.ViewHolder(binding.root) {

    fun bind(pokemon:Pokemon){
        binding.imgPokelist.load(pokemon.img)
        binding.tvNamePokelist.text=pokemon.name
    }
}
