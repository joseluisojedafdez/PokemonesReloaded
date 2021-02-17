package com.i4bchile.pokemonesreloaded.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="pokemon")
data class Pokemon(@PrimaryKey val id:String, val img:String, val name:String)
@Entity(tableName="pokedetail")
data class PokeDetail(val id:String, val img:String, val labels:List<String>, val name:String)