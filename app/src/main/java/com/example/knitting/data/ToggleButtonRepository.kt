package com.example.knitting.data

import androidx.lifecycle.LiveData

class ToggleButtonRepository(private val toggleButtonDao: ToggleButtonDao) {
    val allToggleButtons: LiveData<List<ToggleButton>> = toggleButtonDao.getAllToggleButtons()

    suspend fun insertToggleButton(toggleButton: ToggleButton) {
        toggleButtonDao.insertToggleButton(toggleButton)
    }

    suspend fun updateToggleButton(toggleButton: ToggleButton) {
        toggleButtonDao.updateToggleButton(toggleButton)
    }

    suspend fun initializeToggleButtons() {
        if (toggleButtonDao.getAllToggleButtons().value.isNullOrEmpty()) {
            val initialButtons = List(6) { ToggleButton(isChecked = false) }
            toggleButtonDao.insertToggleButtons(initialButtons)
        }
    }
}
