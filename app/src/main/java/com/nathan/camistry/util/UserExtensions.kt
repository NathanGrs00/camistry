package com.nathan.camistry.util

import com.nathan.camistry.model.PublicProfile
import com.nathan.camistry.model.User

fun User.toPublicProfile(): PublicProfile {
    return PublicProfile(
        id = this.id,
        firstName = this.firstName,
        age = this.age,
        gender = this.gender,
        location = this.location,
        interests = this.interests,
        photos = this.photos
    )
}