package com.i4bchile.pokemonesreloaded.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.i4bchile.pokemonesreloaded.databinding.FragmentDetailBinding
import com.i4bchile.pokemonesreloaded.viewmodel.PokeViewModel

class DetailFragment(): Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel:PokeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentDetailBinding.inflate(inflater)

        viewModel.getPokeDetail().observe(viewLifecycleOwner,{
            binding.imageView.load(it.img)
            binding.tvName.text=it.name
            binding.tvId.text=it.id
            binding.tvLabels.text=it.labels.toString()
        })




        return binding.root
    }

}