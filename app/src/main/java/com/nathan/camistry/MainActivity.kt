package com.nathan.camistry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.controller.PreferencesController
import com.nathan.camistry.controller.UserController
import com.nathan.camistry.model.User
import com.nathan.camistry.repository.PreferencesRepository
import com.nathan.camistry.repository.UserRepository
import com.nathan.camistry.service.CoordinatesToLocationString
import com.nathan.camistry.service.LocationUpdateService
import com.nathan.camistry.ui.overlay.OverlayFragment

class MainActivity : AppCompatActivity(), OverlayFragment.OverlayActionListener {
    private var matchPool: List<User> = emptyList()
    private var currentIndex = 0
    private val userRepository = UserRepository()
    private val userId get() = FirebaseAuth.getInstance().uid
    private lateinit var locationUpdateService: LocationUpdateService

    private lateinit var leadPhotoView: View
    private lateinit var blockBioView: View
    private lateinit var blockBasicInfo: View
    private lateinit var blockInterests: View
    private lateinit var blockLifestyle: View
    private lateinit var rootLayout: LinearLayout

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

        val topbarHeight = resources.getDimensionPixelSize(R.dimen.top_bar_height)
        rootLayout = findViewById(R.id.ll_main_content)
        rootLayout.setPadding(
            rootLayout.paddingLeft,
            topbarHeight,
            rootLayout.paddingRight,
            rootLayout.paddingBottom
        )

        val inflater = LayoutInflater.from(this)
        leadPhotoView = inflater.inflate(R.layout.content_lead, rootLayout, false)
        blockBioView = inflater.inflate(R.layout.content_bio, rootLayout, false)
        blockBasicInfo = inflater.inflate(R.layout.content_info, rootLayout, false)
        blockInterests = inflater.inflate(R.layout.content_interests, rootLayout, false)
        blockLifestyle = inflater.inflate(R.layout.content_lifestyle, rootLayout, false)

        locationUpdateService.getCurrentLocation { currentUserLocation ->
            if (currentUserLocation != null) {
                val userController = UserController(userRepository)
                val prefRepository = PreferencesRepository()
                val prefController = PreferencesController(prefRepository)
                prefController.getPreferences(userId!!) { preferences ->
                    if (preferences == null) {
                        // TODO: Handle case where preferences are not set
                        return@getPreferences
                    }
                    userController.getFilteredUsers(preferences, currentUserLocation) { pool ->
                        if (pool.isNotEmpty()) {
                            matchPool = pool
                            currentIndex = 0
                            showUser(matchPool[currentIndex])
                        } else {
                            // TODO: Display a message indicating no users found
                        }
                    }
                }
            } else {
                // TODO: Handle the case where location is not available
            }
        }
    }

    private fun showUser(user: User) {
        user.photos.firstOrNull()?.let { photoUrl ->
            Glide.with(this)
                .load(photoUrl)
                .into(leadPhotoView.findViewById(R.id.iv_picture_lead))
        }
        leadPhotoView.findViewById<TextView>(R.id.tv_firstname).text = user.firstName
        leadPhotoView.findViewById<TextView>(R.id.tv_age).text = user.age.toString()
        blockBioView.findViewById<TextView>(R.id.tv_bio).text = user.bio
        blockBasicInfo.findViewById<TextView>(R.id.tv_height).text = "${user.heightCm} cm"
        blockBasicInfo.findViewById<TextView>(R.id.tv_gender).text = user.gender
        blockBasicInfo.findViewById<TextView>(R.id.tv_orientation).text = user.orientation ?: "Not specified"
        val cityName = CoordinatesToLocationString().getCityName(
            this,
            user.location.latitude,
            user.location.longitude
        )
        blockBasicInfo.findViewById<TextView>(R.id.tv_location).text = cityName
        blockBasicInfo.findViewById<TextView>(R.id.tv_languages).text = user.languages.joinToString(", ")
        blockLifestyle.findViewById<TextView>(R.id.tv_smokes).text = user.smokes ?: "Not specified"
        blockLifestyle.findViewById<TextView>(R.id.tv_drinks).text = user.drinks ?: "Not specified"
        blockLifestyle.findViewById<TextView>(R.id.tv_has_pets).text = user.hasPets ?: "Not specified"
        blockLifestyle.findViewById<TextView>(R.id.tv_wants_children).text = user.wantsChildren ?: "Not specified"
        blockInterests.findViewById<TextView>(R.id.tv_interests).text =
            if (user.interests.isNotEmpty()) user.interests.joinToString(", ")
            else "No interests specified"

        rootLayout.removeAllViews()
        rootLayout.addView(leadPhotoView)
        rootLayout.addView(blockBioView)
        rootLayout.addView(blockBasicInfo)
        rootLayout.addView(blockInterests)
        rootLayout.addView(blockLifestyle)
    }

    override fun onLike() {
        onLikeOrPass()
    }

    override fun onDislike() {
        onLikeOrPass()
    }

    // Call this when user likes or passes
    private fun onLikeOrPass() {
        if (currentIndex < matchPool.size - 1) {
            currentIndex++
            showUser(matchPool[currentIndex])
        } else {
            // TODO: Show "no more users" message
        }
    }
}