package com.nathan.camistry.ui.topbar

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.nathan.camistry.R

class TopbarFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
        val ivMenu = view.findViewById<ImageView>(R.id.iv_menu)

        ivProfile.setOnClickListener {
            //TODO: Send to profile page
        }

        ivMenu.setOnClickListener {
            // TODO: Open side menu
        }
    }
}