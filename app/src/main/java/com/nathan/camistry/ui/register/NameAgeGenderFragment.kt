package com.nathan.camistry.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nathan.camistry.R
import com.nathan.camistry.viewmodel.UserRegistrationViewModel

class NameAgeGenderFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_name_age_gender, container, false)
        val nameEdit = view.findViewById<EditText>(R.id.et_name)
        val ageEdit = view.findViewById<EditText>(R.id.et_age)
        val etGender = view.findViewById<EditText>(R.id.et_gender)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {
            val name = nameEdit.text.toString()
            val age = ageEdit.text.toString()
            val gender = etGender.text.toString()
            viewModel.user = viewModel.user.copy(
                firstName = name,
                age = age.toIntOrNull() ?: 18,
                gender = gender
            )
            findNavController().navigate(R.id.action_nameAge_to_educationJob)
        }
        return view
    }
}