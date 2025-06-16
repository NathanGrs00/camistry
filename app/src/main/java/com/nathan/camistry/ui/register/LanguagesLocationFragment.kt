package com.nathan.camistry.ui.register

import android.app.Activity
import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.nathan.camistry.R
import com.nathan.camistry.viewmodel.UserRegistrationViewModel

class LanguagesLocationFragment : Fragment() {
    private val viewModel: UserRegistrationViewModel by activityViewModels()
    private var selectedLocation: Location? = null
    private var selectedPlaceName: String = ""
    private val AUTOCOMPLETE_REQUEST_CODE = 1001

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reg_languages_location, container, false)
        val languagesEdit = view.findViewById<EditText>(R.id.et_languages)
        val locationText = view.findViewById<TextView>(R.id.tv_location)
        val interestsEdit = view.findViewById<EditText>(R.id.et_interests)
        val nextBtn = view.findViewById<Button>(R.id.btn_next)

        locationText.setOnClickListener {
            val fields = listOf(Place.Field.ID, Place.Field.NAME, Place.Field.LAT_LNG)
            val intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(requireContext())
            startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)
        }

        nextBtn.setOnClickListener {
            val languages = languagesEdit.text.toString()
            val interests = interestsEdit.text.toString()
            if (selectedLocation == null) {
                Toast.makeText(requireContext(), "Please select a location", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.user = viewModel.user.copy(
                languages = languages.split(",").map { it.trim() },
                location = selectedLocation!!,
                interests = interests.split(",").map { it.trim() }
            )
            // findNavController().navigate(R.id.action_languagesLocation_to_nextStep)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val place = Autocomplete.getPlaceFromIntent(data!!)
            selectedPlaceName = place.name ?: ""
            view?.findViewById<TextView>(R.id.tv_location)?.text = selectedPlaceName

            place.latLng?.let {
                val loc = Location("").apply {
                    latitude = it.latitude
                    longitude = it.longitude
                }
                selectedLocation = loc
            }
        }
    }
}