# 🤝 Contributing to Camistry

Thanks for your interest in contributing to **Camistry**,   
We welcome contributions that help improve code quality, features, and user experience.

---

## 📦 Branching & Git Workflow

We follow the **GitFlow** branching model:

- Base all new work on the `develop` branch.
- Use naming conventions:
  - New features: `feature/your-feature-name`
  - Bug fixes: `hotfix/your-fix-description`

Pull requests should target the `develop` branch. The `master` branch is for production-ready code only and is protected.

---

## 🧪 Development Setup

- Use **Android Studio** (latest stable version preferred)
- **Min SDK:** 24  
- **Target SDK:** 35 (subject to change)

Firebase is used for authentication and Firestore. To run the project locally:

### 🔥 Firebase Setup

1. Create a new Firebase project in [Firebase Console](https://console.firebase.google.com/)
2. Add an Android app to your Firebase project
3. Download the `google-services.json` file
4. Place it in:  
   `app/google-services.json`

Also update the `applicationId` in `app/build.gradle.kts` to your own id you just created:

```kotlin
applicationId = "com.example.camistryclone"
```

---

## ✏️ Code Style Guidelines

- Use tabs for indentation
- camelCase for variable and method names
- PascalCase for class names

Keep code clean, readable, and well-structured. The project follows the MVC architecture:

```
├── ui/             // Activities & Fragments
├── controller/     // Controllers
├── repository/     // Data operations (Firebase, etc.)
├── service/        // Services (Calculators, Generators, etc.)
├── util/           // Reusable utils
```

---

## ✅ Pull Request Requirements

Before submitting a pull request:

- Ensure your code compiles and runs correctly
- Use descriptive commit messages and branch names
- Include a video demonstration if the changes are visible in the app 
  OR attach before/after screenshots
- Optional: Add UnitTests for critical logic

Here’s a sample checklist you can include in your PR description:

### ✅ PR Checklist
- [ ] Code compiles without errors
- [ ] No hardcoded credentials or secrets
- [ ] UI changes are shown in a video or screenshots
- [ ] Branch is based on develop

---

## 📜 License

All contributions to this project are subject to the terms of the  
[LICENSE.md](./LICENSE.md) — **PolyForm Noncommercial License 1.0.0**

> Contributions must be **noncommercial** in nature and comply with the license terms.

---

## 🙌 Final Notes

Please open an **issue** before starting on a major change, or comment on an existing one if you'd like to take it on. We value communication and clarity — it helps the project move forward smoothly.

Thank you for contributing to Camistry! ❤️
