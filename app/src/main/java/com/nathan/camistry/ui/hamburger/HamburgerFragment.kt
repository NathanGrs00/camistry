package com.nathan.camistry.ui.hamburger

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.MainActivity
import com.nathan.camistry.R
import com.nathan.camistry.model.MenuItem
import com.nathan.camistry.ui.login.LoginActivity
import com.nathan.camistry.ui.profile.ProfileActivity

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
                    val intent = Intent(requireContext(), ProfileActivity::class.java)
                    startActivity(intent)
                }
                R.id.action_discover -> {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
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
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    requireActivity().finish()
                }
            }
        }
    }
}