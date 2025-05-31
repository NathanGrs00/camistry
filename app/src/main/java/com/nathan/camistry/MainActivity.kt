package com.nathan.camistry

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nathan.camistry.model.PublicProfile

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val dummyUser = PublicProfile(
            id = "12345",
            firstName = "Bob",
            age = 25,
            bio = "Hello, my name is Bob.",
            heightCm = 184,
            gender = "Male",
            orientation = "Straight",
            intentions = "Long-term relationship",
            languages = listOf("English", "Spanish"),
            location = Location("New York"),
            jobTitle = "Mechanical Engineer",
            education = "Bachelor's in Mechanical Engineering",
            interests = listOf("Hiking", "Cooking", "Reading"),
            smokes = false,
            drinks = true,
            hasPets = "No, but I love animals",
            wantsChildren = "I don't know yet",
            photos = listOf("android.resource://com.nathan.camistry/drawable/dummyphoto"),
            isVerified = true,
            isOnline = true,
        )

        dummyUser.photos[0].let { photoUrl ->
            Glide.with(this)
                .load(photoUrl)
                // TODO: Make placeholder image (user icon?)
                .into(leadPhotoView.findViewById(R.id.iv_picture_lead)
            )
        }

        leadPhotoView.findViewById<TextView>(R.id.tv_firstname).text = dummyUser.firstName
        leadPhotoView.findViewById<TextView>(R.id.tv_age).text = dummyUser.age.toString()
        blockBioView.findViewById<TextView>(R.id.tv_bio).text = dummyUser.bio

        // Add the block view to the root layout.
        rootLayout.addView(leadPhotoView)
        rootLayout.addView(blockBioView)
    }
}