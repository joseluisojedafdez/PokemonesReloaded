package com.i4bchile.pokemonesreloaded.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.i4bchile.pokemonesreloaded.databinding.FragmentListBinding
import com.i4bchile.pokemonesreloaded.viewmodel.PokeViewModel

class ListFragment: Fragment() {

    private lateinit var binding:FragmentListBinding
    private val viewModel:PokeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentListBinding.inflate(inflater)
        val adapter=PokeAdapter()
        binding.rvPokelist.adapter=adapter
        binding.rvPokelist.layoutManager=GridLayoutManager(context,2)
        viewModel.pokeList.observe(viewLifecycleOwner, { pokelist ->pokelist?.let{
            adapter.update(it)}
        })


        return binding.root
    }




}