package com.nathan.camistry.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.R
import com.nathan.camistry.controller.UserController
import com.nathan.camistry.repository.UserRepository

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val topbarHeight = resources.getDimensionPixelSize(R.dimen.top_bar_height)
        // Find the linear layout, where all the blocks will go in.
        val rootLayout = findViewById<LinearLayout>(R.id.ll_main_content)
        rootLayout.setPadding(
            rootLayout.paddingLeft,
            topbarHeight,
            rootLayout.paddingRight,
            rootLayout.paddingBottom
        )

        // Make an inflater to show the blocks
        val inflater = LayoutInflater.from(this)

        // Use the inflater to create a block view for the first photo and bio.
        val leadPhotoView = inflater.inflate(R.layout.content_lead, rootLayout, false)
        val blockBioView = inflater.inflate(R.layout.content_bio, rootLayout, false)
        val blockBasicInfo = inflater.inflate(R.layout.content_info, rootLayout, false)
        val blockInterests = inflater.inflate(R.layout.content_interests, rootLayout, false)
        val blockLifestyle = inflater.inflate(R.layout.content_lifestyle, rootLayout, false)

        val userId = FirebaseAuth.getInstance().uid ?: return
        val userRepository = UserRepository()
        val userController = UserController(userRepository)

        userController.getUser(userId) { user ->
            if (user == null) return@getUser

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
            blockBasicInfo.findViewById<TextView>(R.id.tv_location).text = user.location
            blockBasicInfo.findViewById<TextView>(R.id.tv_languages).text = user.languages.joinToString(", ")

            blockLifestyle.findViewById<TextView>(R.id.tv_smokes).text = user.smokes ?: "Not specified"
            blockLifestyle.findViewById<TextView>(R.id.tv_drinks).text = user.drinks ?: "Not specified"
            blockLifestyle.findViewById<TextView>(R.id.tv_has_pets).text = user.hasPets ?: "Not specified"
            blockLifestyle.findViewById<TextView>(R.id.tv_wants_children).text = user.wantsChildren ?: "Not specified"

            // Add the block view to the root layout.
            rootLayout.addView(leadPhotoView)
            rootLayout.addView(blockBioView)
            rootLayout.addView(blockBasicInfo)
            rootLayout.addView(blockInterests)
            rootLayout.addView(blockLifestyle)
        }

//        val dummyUser = PublicProfile(
//            id = "12345",
//            firstName = "Bob",
//            age = 25,
//            bio = "Hello, my name is Bob.",
//            heightCm = 184,
//            gender = "Male",
//            orientation = "Straight",
//            intentions = "Long-term relationship",
//            languages = listOf("English", "Spanish"),
//            location = Location("New York"),
//            jobTitle = "Mechanical Engineer",
//            education = "Bachelor's in Mechanical Engineering",
//            interests = listOf("Hiking", "Cooking", "Reading"),
//            smokes = "No, but I don't mind if you do",
//            drinks = "Socially",
//            hasPets = "No, but I love animals",
//            wantsChildren = "I don't know yet",
//            photos = listOf("android.resource://com.nathan.camistry/drawable/dummyphoto"),
//            isVerified = true,
//            isOnline = true,
//        )
    }
}