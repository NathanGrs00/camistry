package com.nathan.camistry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.pm.PackageManager
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.repository.UserRepository
import com.nathan.camistry.service.LocationUpdateService

class MainActivity : AppCompatActivity() {
    private val userRepository = UserRepository()
    private val userId get() = FirebaseAuth.getInstance().uid
    private lateinit var locationUpdateService: LocationUpdateService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationUpdateService = LocationUpdateService(this, userRepository)

        if (userId == null) return

        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100
            )
        } else {
            locationUpdateService.updateUserLocation(userId!!)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 &&
            grantResults.isNotEmpty() &&
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            userId?.let { locationUpdateService.updateUserLocation(it) }
        }
    }
}