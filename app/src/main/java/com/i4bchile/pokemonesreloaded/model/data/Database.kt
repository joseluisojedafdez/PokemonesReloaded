package com.i4bchile.pokemonesreloaded.model.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import com.i4bchile.pokemonesreloaded.model.Pokemon


@Dao
interface PokeDao{

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun loadAllPokemons(pokeList:List<Pokemon>)

    @Query("SELECT * FROM pokemon")
    fun getAlPokemons(): LiveData<List<Pokemon>>


}

@Database(entities=[Pokemon::class], version=1)

@TypeConverters(Converters::class)
abstract class PokeDatabase: RoomDatabase() {
    abstract fun pokeDao():PokeDao
}

class PokeApplication: Application(){
    companion object{
        var pokeDatabase:PokeDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()

        pokeDatabase= Room.databaseBuilder(this,PokeDatabase::class.java,"poke_db").build()
    }
}
