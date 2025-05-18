package com.nathan.camistry.ui.overlay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.nathan.camistry.R

class OverlayFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overlay_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val iconSize = resources.getDimensionPixelSize(R.dimen.icon_size)

        val btnLike = view.findViewById<Button>(R.id.btn_like)
        val btnDislike = view.findViewById<Button>(R.id.btn_dislike)
        val iconLike = btnLike.compoundDrawablesRelative[0]
        val iconDislike = btnDislike.compoundDrawablesRelative[0]

        iconLike.setBounds(0,0, iconSize, iconSize)
        iconDislike.setBounds(0,0, iconSize, iconSize)

        btnLike.setCompoundDrawablesRelative(iconLike, null, null, null)
        btnDislike.setCompoundDrawablesRelative(iconDislike, null, null, null)

        btnLike.setOnClickListener {
            //TODO: Handle like button click
        }

        btnDislike.setOnClickListener {
            // TODO: Handle dislike button click
        }
    }
}