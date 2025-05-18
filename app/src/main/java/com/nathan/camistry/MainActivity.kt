package com.nathan.camistry

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the linear layout, where all the blocks will go in.
        val rootLayout = findViewById<LinearLayout>(R.id.ll_main_content)
        // Make an inflater to show the blocks
        val inflater = LayoutInflater.from(this)

        // Use the inflater to create a block view for the first photo and bio.
        val leadPhotoView = inflater.inflate(R.layout.content_lead, rootLayout, false)
        val blockBioView = inflater.inflate(R.layout.content_bio, rootLayout, false)

        //TODO: Make the bio dynamic.
        leadPhotoView.findViewById<TextView>(R.id.tv_firstname).text = "Bob"
        leadPhotoView.findViewById<TextView>(R.id.tv_age).text = "25"
        blockBioView.findViewById<TextView>(R.id.tv_bio).text = "Hello, my name is Bob."

        // Add the block view to the root layout.
        rootLayout.addView(leadPhotoView)
        rootLayout.addView(blockBioView)
    }
}