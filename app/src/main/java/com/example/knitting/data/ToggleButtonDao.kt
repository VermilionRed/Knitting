package com.example.knitting.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ToggleButtonDao {
    @Query("SELECT * FROM toggle_buttons")
    fun getAllToggleButtons(): LiveData<List<ToggleButton>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToggleButton(toggleButton: ToggleButton)

    @Update
    suspend fun updateToggleButton(toggleButton: ToggleButton)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToggleButtons(toggleButtons: List<ToggleButton>)
}

