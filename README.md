# 📚 Master Ji – Learning App

Mobile app that teaches algorithms with help of beautiful animation.

This project follows a **Feature-based Modular Architecture** with **Jetpack Compose**.  
It is designed for **scalability, maintainability, and reusability** in building a learning platform that teaches **Algorithms** and **Data Structures**.

---

## 🏗 Project Structure

```
app/
│── core/                     # Shared code across all features
│   ├── ui/                   # Common UI components
│   │   ├── components/       # Buttons, Cards, Dialogs, Loaders
│   │   ├── theme/            # Colors, Typography, Shapes
│   │   └── utils/            # Layout helpers (Spacing, Modifiers)
│   ├── navigation/           # Centralized navigation setup
│   ├── network/              # API client & response handling
│   ├── database/             # Shared persistence (Room/SQLDelight)
│   ├── di/                   # Dependency Injection setup
│   └── resources/            # Strings, icons, animations
│
│── feature_algorithm/        # Algorithms feature
│   ├── ui/                   # Screens, Compose components
│   ├── domain/               # UseCases, business logic
│   └── data/                 # Repository, Models, API, DB
│
│── feature_datastructure/    # Data Structures feature
│   ├── ui/
│   ├── domain/
│   └── data/
│
│── feature_visualization/    # Visualization feature (animations, diagrams)
│── feature_profile/          # User Profile, progress, settings
│── feature_home/             # Entry point, dashboard
```

---

## 🔑 Core Principles

1. **Feature-first structure**
    - Each feature has its own **UI, domain, data** layers.
    - Keeps code modular and avoids a giant `ui/` folder.

2. **Separation of Concerns**
    - `ui/` → Compose screens & components
    - `domain/` → Business logic (UseCases, state handling)
    - `data/` → Repository, network, and database

3. **Scalability**
    - New features = new `feature_xxx` module.
    - Core stays stable while features evolve independently.

4. **Reusability**
    - Shared UI (buttons, dialogs, loaders) lives in `core/ui/components/`.
    - Shared infra (network, DB, DI) lives in `core/`.

---

## 🎨 UI Guidelines

- **PrimaryButton** → solid background, brand color, main action per screen
- **SecondaryButton** → outlined, alternative action
- **TertiaryButton** → text-only, low emphasis
- Typography & Spacing defined centrally in `core/ui/theme/`

---

## 🛠 Tech Stack

- **Jetpack Compose** – Modern UI toolkit
- **Hilt (DI)** – Dependency injection
- **Room/SQLDelight** – Persistence
- **Retrofit/Ktor** – Networking
- **Accompanist / Coil** – Images, animations
- **Material 3** – Theming & components

---

## 🚀 Feature Flow Example

- **Home** → Browse Algorithms & Data Structures
- **Algorithm Feature** → List + Detail + Visualization → Quiz
- **Data Structure Feature** → List + Detail + Visualization → Quiz
- **Profile Feature** → Progress tracking, achievements

---

## 📦 Core Components

- `AppButton` (Primary, Secondary, Tertiary)
- `AppCard` (for lessons, DS/Algo blocks)
- `AppDialog` (update prompts, confirmations)
- `LoadingState`, `EmptyState`, `ErrorState`
- `AppScaffold` (base layout with top/bottom bars)

---

## ✅ Benefits

- 🔹 Clear feature boundaries → easier onboarding for devs
- 🔹 Modular code → faster builds, reusable pieces
- 🔹 Consistent UI → buttons, typography, spacing unified in core
- 🔹 Easier testing → feature isolation

---

📘 **Next Steps**:
- Add **Analytics** module in `core/analytics/`.
- Create **Design System doc** (color palette, typography scale).
- Expand **Visualization feature** with interactive animations.

---

👉 This README sets the foundation for both **new contributors** and **long-term maintainability**.