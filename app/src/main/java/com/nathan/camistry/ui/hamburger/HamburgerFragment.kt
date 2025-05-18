package com.nathan.camistry.ui.hamburger

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nathan.camistry.R
import com.nathan.camistry.model.MenuItem

class HamburgerFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hamburger_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuItems = listOf(
            MenuItem("Profile", R.drawable.ic_user_profile),
            MenuItem("Connections", R.drawable.ic_videocam),
            MenuItem("Notifications", R.drawable.ic_notification_bell),
            MenuItem("Subscription", R.drawable.ic_lock),
            MenuItem("About", R.drawable.ic_heart_question),
            MenuItem("Settings", R.drawable.ic_settings),
            MenuItem("Logout", R.drawable.ic_logout)
        )

        val menuList = view.findViewById<RecyclerView>(R.id.rv_menu)
        menuList.layoutManager = LinearLayoutManager(context)
        menuList.adapter = MenuAdapter(menuItems) { menuItem ->
            when (menuItem.title) {
                "Profile" -> {
                    // Handle Profile click
                }

                "Connections" -> {
                    // Handle Connections click
                }

                "Notifications" -> {
                    // Handle Notifications click
                }

                "Subscription" -> {
                    // Handle Subscription click
                }

                "About" -> {
                    // Handle About click
                }

                "Settings" -> {
                    // Handle Settings click
                }

                "Logout" -> {
                    // Handle Logout click
                }
            }
        }
    }
}