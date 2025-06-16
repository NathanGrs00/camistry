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

class JobEducationFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_education_job, container, false)
        val educationEdit = view.findViewById<EditText>(R.id.et_education)
        val jobEdit = view.findViewById<EditText>(R.id.et_job)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {
            val education = educationEdit.text.toString()
            val job = jobEdit.text.toString()
            viewModel.user = viewModel.user.copy(
                education = education,
                jobTitle = job
            )
            // findNavController().navigate(R.id.action_educationJob_to_nextStep)
        }
        return view
    }
}