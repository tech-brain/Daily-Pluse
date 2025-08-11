# 📰 KMM News App  

<p align="center">
  <img src="https://img.shields.io/badge/Kotlin-1.9-blue?logo=kotlin&logoColor=white" />
  <img src="https://img.shields.io/badge/Swift-5-orange?logo=swift&logoColor=white" />
  <img src="https://img.shields.io/badge/Jetpack%20Compose-UI-green?logo=jetpackcompose&logoColor=white" />
  <img src="https://img.shields.io/badge/SwiftUI-iOS-blue?logo=apple&logoColor=white" />
  <img src="https://img.shields.io/badge/KMM-Cross%20Platform-purple" />
  <img src="https://img.shields.io/badge/Ktor-Networking-yellow" />
  <img src="https://img.shields.io/badge/SQLDelight-Offline%20Storage-lightgrey" />
  <img src="https://img.shields.io/badge/Koin-DI-ff69b4" />
</p>

A cross-platform **News App** built with **Kotlin Multiplatform Mobile (KMM)** that displays top headlines from the free [News API](https://newsapi.org).  
The app shares business logic across Android and iOS while delivering native UI experiences for both platforms.

---

## ✨ Features
- 📰 **Top Headlines** – Fetches the latest news with image, description, and published date  
- 📱 **Device Info Screen** – Displays OS version, device name, and other details  
- 📦 **Offline Support** – Caches data locally using **SQLDelight** until new data is loaded  
- 🧠 **Clean Architecture** – Organized for maintainability & scalability  
- 🛠 **MVVM Pattern** – For better state management  
- 🧩 **Dependency Injection** – Using **Koin**  
- 🔄 **Cross-Platform Business Logic** – One shared codebase for networking, data handling, and caching  
- 🎨 **Native UI** – Jetpack Compose (Android) + SwiftUI (iOS)  

---

## 🛠 Tech Stack
### Shared (KMM)
- 🛠 **Kotlin Multiplatform Mobile (KMM)** – Shared business logic  
- 🧩 **Koin** – Dependency Injection  
- 🌐 **Ktor** – Networking  
- 💾 **SQLDelight** – Local data storage  
- 🧠 **Clean Architecture + MVVM**

### Android
- 🎨 **Jetpack Compose** – Declarative UI  
- 🎯 **Material Design 3** Components  

### iOS
- 🎨 **SwiftUI** – Declarative UI for iOS  

---

## 📸 Screenshots  
*(Add screenshots from both Android & iOS here)*  
Android Screenshots:-
<p float="left">
  <img width="300" alt="Screenshot_20250812_012836" src="https://github.com/user-attachments/assets/23168bd2-62e2-4589-a25b-e8d2dae7fe78" />
  <img width="300" alt="Screenshot_20250812_012009" src="https://github.com/user-attachments/assets/88a5d5e8-3f35-4d60-b919-c3f6fd5d600e" />
</p>

iOS Screenshots
<p align="center">
  <img src="https://github.com/user-attachments/assets/1abe5d9e-6606-467c-8b4e-4f5856196f15" alt="Simulator Screenshot - iPhone 16 - 2025-08-12 at 01 26 44" width="300" />
  <img src="https://github.com/user-attachments/assets/56c83d5f-9834-4601-bb77-e14a81574093" alt="Simulator Screenshot - iPhone 16 - 2025-08-12 at 01 26 56" width="300" />
</p>


---

## 🚀 Getting Started


### Prerequisites
- Android Studio (latest stable version)  
- Xcode (for iOS development)  
- [News API Key](https://newsapi.org) – Sign up and get a free API key  

### Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/KMM-News-App.git
