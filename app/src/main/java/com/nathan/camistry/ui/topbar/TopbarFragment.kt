package com.nathan.camistry.ui.topbar

import android.animation.ObjectAnimator
import android.view.MotionEvent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.animation.doOnEnd
import androidx.fragment.app.Fragment
import com.nathan.camistry.R

class TopbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_topbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivProfile = view.findViewById<ImageView>(R.id.iv_profile)
        val ivMenu = view.findViewById<ImageView>(R.id.iv_menu)

        ivProfile.setOnClickListener {
            //TODO: Send to profile page
        }

        // If the user clicks on the menu icon, show the hamburger menu and the blocker
        ivMenu.setOnClickListener {
            slideIn()
        }
    }

    private fun slideIn(){
        val menu = requireActivity().findViewById<View>(R.id.fcv_hamburger)
        val blocker = requireActivity().findViewById<View>(R.id.overlay_blocker)
        menu.visibility = View.VISIBLE
        blocker.visibility = View.VISIBLE

        menu.post {
            ObjectAnimator.ofFloat(menu, "translationX", -menu.width.toFloat(), 0f).apply {
                duration = 400
                start()
            }
        }

        // If the user clicks on the blocker, close the menu
        blocker.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                blocker.performClick()
                ObjectAnimator.ofFloat(menu, "translationX", 0f, -menu.width.toFloat()).apply {
                    duration = 400
                    start()
                }.doOnEnd {
                    menu.visibility = View.GONE
                    blocker.visibility = View.GONE
                }
            }
            true
        }
    }
}