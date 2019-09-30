package br.com.programacaodinamica.randomcolor.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.programacaodinamica.randomcolor.model.NamedColor

@Dao
interface NamedColorDAO {

    @Query("SELECT * from Color ORDER BY timestamp DESC")
    fun allColors(): LiveData<List<NamedColor>>

    @Query("SELECT * from Color WHERE _name LIKE :colorName")
    fun findByName(colorName: String): List<NamedColor>

    @Insert
    fun insert(color: NamedColor)

    @Delete
    fun delete(color: NamedColor)
}