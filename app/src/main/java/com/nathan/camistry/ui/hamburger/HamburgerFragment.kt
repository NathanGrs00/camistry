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
        val icProfile = getString(R.string.title_profile)
        val icConnections = getString(R.string.title_connections)
        val icNotifications = getString(R.string.title_notifications)
        val icSubscription = getString(R.string.title_subscription)
        val icAbout = getString(R.string.title_about)
        val icSettings = getString(R.string.title_settings)
        val icLogout = getString(R.string.title_logout)

        val menuItems = listOf(
            MenuItem(icProfile, R.drawable.ic_user_profile),
            MenuItem(icConnections, R.drawable.ic_videocam),
            MenuItem(icNotifications, R.drawable.ic_notification_bell),
            MenuItem(icSubscription, R.drawable.ic_lock),
            MenuItem(icAbout, R.drawable.ic_heart_question),
            MenuItem(icSettings, R.drawable.ic_settings),
            MenuItem(icLogout, R.drawable.ic_logout)
        )

        val menuList = view.findViewById<RecyclerView>(R.id.rv_menu)
        menuList.layoutManager = LinearLayoutManager(context)
        menuList.adapter = MenuAdapter(menuItems) { menuItem ->
            when (menuItem.title) {
                icProfile -> {
                    // Handle Profile click
                }

                icConnections -> {
                    // Handle Connections click
                }

                icNotifications -> {
                    // Handle Notifications click
                }

                icSubscription -> {
                    // Handle Subscription click
                }

                icAbout -> {
                    // Handle About click
                }

                icSettings -> {
                    // Handle Settings click
                }

                icLogout -> {
                    // Handle Logout click
                }
            }
        }
    }
}