package com.example.knitting.ui.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.knitting.data.AppDatabase
import com.example.knitting.data.ToggleButton
import com.example.knitting.data.ToggleButtonRepository
import kotlinx.coroutines.launch

class ToggleButtonViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ToggleButtonRepository
    val allToggleButtons: LiveData<List<ToggleButton>>

    init {
        val toggleButtonDao = AppDatabase.getDatabase(application).toggleButtonDao()
        repository = ToggleButtonRepository(toggleButtonDao)
        allToggleButtons = repository.allToggleButtons
        viewModelScope.launch {
            repository.initializeToggleButtons()
        }
    }

    fun insertToggleButton(toggleButton: ToggleButton) = viewModelScope.launch {
        repository.insertToggleButton(toggleButton)
    }

    fun updateToggleButton(toggleButton: ToggleButton) = viewModelScope.launch {
        repository.updateToggleButton(toggleButton)
    }
}

data class ToggleButtonUiState(
    val toggleButtons: List<ToggleButton> = emptyList()
)

