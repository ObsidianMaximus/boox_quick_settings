# QS (Boox Quick Settings)

A lightweight launcher shortcut for Onyx Boox devices that pulls down the Quick Settings / Control Center panel via an Accessibility top-edge swipe gesture (`dispatchGesture`).

## Features
- Zero UI views or stacked Activities (`Theme.NoDisplay` + `finishAndRemoveTask()`)
- Zero Accessibility event listeners (0% idle CPU usage, ~5 MB private RAM)
- Dynamically adapts swipe coordinates to both portrait and landscape orientations

## Setup
1. Install the APK (`adb install -r BooxQuickSettings-debug.apk`).
2. Enable **QS** under **Settings -> Accessibility**, or run via ADB:
   `adb shell settings put secure enabled_accessibility_services com.boox.quicksettings/com.boox.quicksettings.QuickSettingsService`
3. Tap the **QS** icon to pull down Quick Settings.
