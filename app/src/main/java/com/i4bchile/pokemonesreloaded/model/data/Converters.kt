package com.i4bchile.pokemonesreloaded.model.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun list2String(list: List<String>): String {
        return list.joinToString()
    }

    @TypeConverter
    fun string2List(value: String): List<String> {
        return value.split(",").map {
            it.trim()
        }
    }
}