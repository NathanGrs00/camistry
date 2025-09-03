package com.nathan.camistry.controller

import com.nathan.camistry.model.DiscoverPreferences
import com.nathan.camistry.repository.PreferencesRepository

class PreferencesController(private val prefRepository: PreferencesRepository) {
    fun getPreferences(userId: String, onResult: (DiscoverPreferences?) -> Unit) {
        prefRepository.getPreferences(userId, onResult)
    }
}