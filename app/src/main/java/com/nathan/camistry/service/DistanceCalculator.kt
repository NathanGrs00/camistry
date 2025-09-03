package com.nathan.camistry.service

import android.location.Location

class DistanceCalculator {
    fun calculateDistance(loc1: Location, loc2: Location): Int {
        return loc1.distanceTo(loc2).toInt() / 1000 // returns distance in km
    }
}