package com.nathan.camistry.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.nathan.camistry.R
import com.nathan.camistry.viewmodel.UserRegistrationViewModel
import androidx.fragment.app.activityViewModels

class HeightOrientationIntentionFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_height_orientation_intention, container, false)
        val heightEdit = view.findViewById<EditText>(R.id.et_height)
        val orientationEdit = view.findViewById<EditText>(R.id.et_orientation)
        val intentionEdit = view.findViewById<EditText>(R.id.et_intention)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {
            val height = heightEdit.text.toString()
            val orientation = orientationEdit.text.toString()
            val intention = intentionEdit.text.toString()
            viewModel.user = viewModel.user.copy(
                heightCm = height.toIntOrNull() ?: 0,
                orientation = orientation,
                intentions = intention
            )
            // findNavController().navigate(R.id.action_heightOrientationIntention_to_nextStep)
        }
        return view
    }
}