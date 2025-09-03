package com.nathan.camistry.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.firebase.auth.FirebaseAuth
import com.nathan.camistry.MainActivity
import com.nathan.camistry.R
import com.nathan.camistry.controller.UserController
import com.nathan.camistry.repository.UserRepository
import com.nathan.camistry.viewmodel.UserRegistrationViewModel

class InterestFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()
    private val userRepository = UserRepository()
    private val userController = UserController(userRepository)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_interest, container, false)
        val interestsEdit = view.findViewById<EditText>(R.id.et_interests)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        nextBtn.setOnClickListener {
            val interests = interestsEdit.text.toString()
            val uid = FirebaseAuth.getInstance().currentUser?.uid
            if (uid == null) {
                Toast.makeText(requireContext(), "User not authenticated", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val user = viewModel.user.copy(
                id = uid,
                interests = interests.split(",").map { it.trim() }
            )
            userController.updateUser(user) { success ->
                if (success) {
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                } else {
                    Toast.makeText(requireContext(), "Failed to save profile", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}