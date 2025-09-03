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

class LanguagesFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_languages, container, false)
        val languagesEdit = view.findViewById<EditText>(R.id.et_languages)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {
            val languages = languagesEdit.text.toString()
            viewModel.user = viewModel.user.copy(
                languages = languages.split(",").map { it.trim() }
            )
            findNavController().navigate(R.id.action_languages_to_interest)
        }
        return view
    }
}