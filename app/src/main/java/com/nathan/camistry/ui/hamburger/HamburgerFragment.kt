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
            MenuItem(getString(R.string.title_profile), R.drawable.ic_user_profile, R.id.action_profile),
            MenuItem(getString(R.string.title_discover), R.drawable.ic_search, R.id.action_discover),
            MenuItem(getString(R.string.title_connections), R.drawable.ic_videocam, R.id.action_connections),
            MenuItem(getString(R.string.title_notifications), R.drawable.ic_notification_bell, R.id.action_notifications),
            MenuItem(getString(R.string.title_subscription), R.drawable.ic_lock, R.id.action_subscription),
            MenuItem(getString(R.string.title_about), R.drawable.ic_heart_question, R.id.action_about),
            MenuItem(getString(R.string.title_settings), R.drawable.ic_settings, R.id.action_settings),
            MenuItem(getString(R.string.title_logout), R.drawable.ic_logout, R.id.action_logout)
        )

        val menuList = view.findViewById<RecyclerView>(R.id.rv_menu)
        menuList.layoutManager = LinearLayoutManager(context)
        menuList.adapter = MenuAdapter(menuItems) { menuItem ->
            when (menuItem.actionId) {
                R.id.action_profile -> {
                    // TODO: navigate to Profile
                }
                R.id.action_discover -> {
                    // TODO: navigate to Discover
                }
                R.id.action_connections -> {
                    // TODO: navigate to Connections
                }
                R.id.action_notifications -> {
                    // TODO: navigate to Notifications
                }
                R.id.action_subscription -> {
                    // TODO: navigate to Subscription
                }
                R.id.action_about -> {
                    // TODO: navigate to About
                }
                R.id.action_settings -> {
                    // TODO: navigate to Settings
                }
                R.id.action_logout -> {
                    // TODO: handle logout
                }
            }
        }
    }
}