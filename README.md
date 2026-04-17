# T-UI Linux CLI Launcher (Modernized Fork)

Welcome to the modernized fork of the renowned T-UI Android Launcher. This fork revitalizes the project by bringing its entire Android build lifecycle up to modern development standards. It ensures that the application easily compiles on modern developer setups while maximizing compatibility with the newest Android platforms.

## 🚀 Fork Changes & Modernization

This fork specifically introduces the following crucial infrastructure updates to keep the project alive and developer-friendly:

*   **Migrated to Kotlin DSL:** Completely replaced legacy Groovy build scripts with modern, type-safe Kotlin DSL (`.gradle.kts`).
*   **Java 17 Readiness:** Upgraded the source compilation config to Java 17.
*   **Android 15 Compatibility:** Bumped both `compileSdk` and `targetSdk` to **API 35 (Android 15)**.
*   **Gradle & Tools:** Upgraded to **Gradle 8.9** and **Android Gradle Plugin 8.5.0**.
*   **Developer-Friendly Keystores:** Restructured signing config so anyone can successfully run `assembleDebug` without requiring the original author's private signature.
*   **AndroidX:** Fully uses AndroidX libraries.

---

## 🌟 Original Core Features

The classic launcher functionality remains fully intact, secure, and performant on Android 11 through Android 15+:

> **Pro Tip:** On the very first install, if background transparency does not take effect immediately, simply type \`restart\` in the terminal and press enter.

### ⌨️ New Commands
*   **`username [user] [device]`**: Instantly customize your terminal prompt. Changes both the username and device name and reloads the UI to apply.
*   **`theme -preset [name]`**: Rapidly switch between high-quality pre-configured themes.
    *   **Available Presets:** `blue`, `red`, `green`, `pink`, `bw`, `cyberpunk`.
    *   **Smart Suggestions:** Applying a preset automatically colors the suggestion bar and shortcut buttons to match the aesthetic.
*   **`bbman`**: The new BusyBox manager for installing and verifying Linux binaries.

### ✨ Enhanced Features
*   **Built-in BusyBox Manager:** Gain access to 300+ Linux commands (ls, grep, awk, top, etc.) via the new `bbman -install` command.
*   **Theme Preset Shortcut Buttons:** Enhanced the `theme -preset` command to show interactive shortcut buttons for presets.
*   **Synchronized Theme UI:** Applying a preset now automatically colors the shortcut buttons (suggestions) to match the overall theme.
*   **One-Tap Application:** Shortcut buttons for theme presets execute immediately upon clicking.

---

## 🐧 BusyBox Integration

To enable a full Linux environment, you can install BusyBox directly from the launcher:

1.  Type `bbman -install` in the terminal.
2.  The launcher will automatically detect your architecture, download the verified binary, and check its integrity.
3.  Once finished, you can run any Linux command directly (e.g., `ls`, `ping`, `vi`).
4.  To remove it at any time, use `bbman -remove`.

**Security Note:** Binaries are sourced from the trusted EXALAB repository and are verified against hardcoded SHA-256 hashes to ensure they have not been tampered with.

---

## 🛡 Security Hardening (OWASP MASVS Compliance)

This project has been audited and hardened following the **OWASP Mobile Application Security Verification Standard (MASVS)**.

### 📦 MASVS-STORAGE: Data Storage and Privacy
*   **Scoped Storage Implementation:** All application data has been moved from public external storage (`/sdcard/t-ui/`) to secure, app-private **Scoped Storage** (`Context.getExternalFilesDir()`). This prevents other applications from accessing your T-UI configuration and logs.
*   **Backup Protection:** `android:allowBackup` is set to `false` to prevent sensitive data extraction via ADB backups (MASVS-STORAGE-1).
*   **Secure File Sharing:** Uses `FileProvider` for secure, permission-based file sharing instead of vulnerable `file://` URIs.

### 🌐 MASVS-NETWORK: Network Communication
*   **Enforced TLS:** `android:usesCleartextTraffic` is disabled globally. All network communications are forced over **HTTPS** (TLS 1.2+).
*   **Hardened Service Endpoints:** Internal services (Weather API, Connectivity checks) have been upgraded to secure HTTPS endpoints (MASVS-NETWORK-1).

### ⚙️ MASVS-PLATFORM: Platform Interaction
*   **Signature-Level Protection:** Implemented a custom permission `ohi.andre.consolelauncher.permission.RECEIVE_CMD` with `protectionLevel="signature"`. This ensures only apps signed with the same developer key can programmatically send commands to the launcher.
*   **Intent Security:** All system-bound `PendingIntents` use the `FLAG_IMMUTABLE` flag to prevent intent redirection attacks (Android 12+ requirement).
*   **Receiver Security:** All Broadcast Receivers are registered with appropriate export flags (`RECEIVER_EXPORTED` or `RECEIVER_NOT_EXPORTED`) to prevent unauthorized external triggers.

### 🛠 MASVS-CODE: Code Quality & Build Settings
*   **Minification & Obfuscation:** Release builds have R8/Proguard enabled (`minifyEnabled true`) to shrink resources and obfuscate code, making reverse engineering more difficult (MASVS-RESILIENCE-1).
*   **Foreground Service Security:** Updated to comply with Android 14's strict foreground service types (`specialUse`, `mediaPlayback`).

---

## 🔗 Useful links

**Official community**&nbsp;&nbsp;-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**[Reddit](https://www.reddit.com/r/tui_launcher/)**<br>
**Official Group**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**[Telegram](https://t.me/tuilauncher)**<br>
**Wiki**&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**[GitHub.com](https://github.com/Andre1299/TUI-ConsoleLauncher/wiki)**<br>

## 📚 Open Source Libraries
* [**CompareString2**](https://github.com/fAndreuzzi/CompareString2)
* [**OkHttp**](https://github.com/square/okhttp)
* [**HTML cleaner**](http://htmlcleaner.sourceforge.net/)
* [**JsonPath**](https://github.com/json-path/JsonPath)
* [**jsoup**](https://github.com/jhy/jsoup/)
