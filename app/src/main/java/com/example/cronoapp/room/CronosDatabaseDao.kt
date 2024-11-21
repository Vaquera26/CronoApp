package com.example.cronoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cronoapp.model.Cronos
import kotlinx.coroutines.flow.Flow

// Interface -> repositorio -> ViewModel -> View
@Dao // Data Access Object
interface CronosDatabaseDao {
    // Crud
    @Query("Select * from cronos")
    fun getCronos(): Flow<List<Cronos>>

    @Query("Select * from cronos where id=:id")
    fun getCronosById(id: Long): Flow<Cronos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cronos: Cronos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(cronos: Cronos)

    @Delete
    suspend fun delete(cronos: Cronos)
}
