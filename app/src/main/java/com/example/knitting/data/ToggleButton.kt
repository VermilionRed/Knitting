package com.example.knitting.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toggle_buttons")
data class ToggleButton(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val isChecked: Boolean
)
