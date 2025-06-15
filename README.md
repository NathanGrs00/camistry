# 💞 Camistry

**Camistry** is a video-first dating app designed to encourage genuine human connection.  
Before two users can exchange messages, they must first schedule and complete a **video call** — bringing authenticity and safety back to online dating.

---

## 📱 About

Camistry is built with **Kotlin** for Android and uses **Firebase** for authentication and backend services.  
The app emphasizes **intentional connection**: one match per day, video before text, and user-first safety features.

> 🛠️ **Status**: Early Development — expect frequent changes and incomplete features.

---

## ✨ Features

- 🔐 **Email/password login and registration** using Firebase Authentication
- 🎥 **Video call before chat**: Users must plan and complete a video call before unlocking text messaging (planned)
- 🧠 **Profile system** with interests and lifestyle data (in progress)
- 📝 **Face verification** (planned)
- 💡 **Smart matching system** (planned)
    - One match per day
    - 24 hours to schedule a video call
    - 7 days to complete the call
- 📸 **Profile image upload** via Firebase Storage (planned)

---

## 🔧 Tech Stack

- **Language**: Kotlin
- **UI**: XML Layouts (ConstraintLayout)
- **Backend**: Firebase
  - Firebase Auth (Email/Password)
  - Cloud Firestore (in progress)
  - Firebase Storage (planned)

---

## 🗂 Project Structure (MVC Pattern)
```
  app/
  ├── ui/ # Activities (LoginActivity, RegisterActivity, etc.)
  ├── controller/ # Controllers for handling business logic
  ├── repository/ # Repositories interfacing with Firebase
  ├── util/ # Input and validation utilities
  ├── service/ # Calculations or other external integrations
```

---

## 🖼 Screenshots

Coming soon.

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/NathanGrs00/camistry.git
```

### 2. Firebase Setup

To run Camistry locally, you'll need your own Firebase project.

1. Go to the [Firebase Console](https://console.firebase.google.com/)
2. Create a new Firebase project
3. Add an **Android app** to your project
4. Download the `google-services.json` file
5. Place the file in your project at:
```
app/google-services.json
```

---

### 3. Update `applicationId`

To avoid build conflicts:

1. Open `app/build.gradle.kts`
2. Change the `applicationId` from:

```kotlin
applicationId = "com.nathan.camistry"
```
to the name you gave the project in the Firebase Console:
```kotlin
applicationId = "com.example.camistryclone"
```

## 🧪 Development Notes

- **Camistry** is **Android-only** for now. iOS may be considered in the future.
- Layouts should be optimized using `ConstraintLayout` with **centralized horizontal and vertical bias**.
- All dimensions and spacing values are being standardized via `res/values/dimens.xml`.
- All string values are stored in `res/values/strings.xml`.

---

## 🧑‍💻 Contributing

We welcome contributions! Please follow these steps:

1. **Open an issue** or comment on an existing one before starting work.
2. **Fork** the repository.
3. **Create a new branch** with a descriptive name.
4. **Submit a pull request** with clear and concise commits.

> 🔒 **Note:** Contributions must comply with the noncommercial licensing terms below.

---

## 📜 License

Camistry is licensed under the [PolyForm Noncommercial License 1.0.0](https://polyformproject.org/licenses/noncommercial/1.0.0/).

See the full license in the [LICENSE.md](./LICENSE.md) file.

Copyright © 2025 Nathan Geers

---

## 💬 Contact

For questions, feedback, or ideas, feel free to:

- [Open an issue](../../issues) on GitHub  
- Reach out on [LinkedIn](https://www.linkedin.com/in/your-linkedin-profile)

---
