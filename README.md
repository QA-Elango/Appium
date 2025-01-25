# Appium

# Android Debug Bridge (ADB) Setup and Node.js Configuration

This document provides step-by-step instructions to set up `adb` (Android Debug Bridge), configure the necessary environment variables, and install `Node.js` for use with tools like Appium.

---

## **1. Prerequisites**
1. Download and install [Android Studio](https://developer.android.com/studio).
2. Install the Android SDK during the Android Studio setup.

---

## **2. Set Up ADB**

### **2.1 Locate the SDK Path**
By default, the Android SDK is installed in:

### **2.2 Add ANDROID_HOME to Environment Variables**
1. Open **Environment Variables**:
   - Press `Win + S`, search for **Environment Variables**.
   - Click **Edit the system environment variables**.

2. Add a new **System Variable**:
   - **Variable Name**: `ANDROID_HOME`
   - **Variable Value**: Path to your Android SDK (e.g., `C:\Users\<YourUserName>\AppData\Local\Android\Sdk`).

3. Update the `Path` Variable:
   - Add the following paths to the `Path` variable:
     ```
     %ANDROID_HOME%\platform-tools
     %ANDROID_HOME%\tools
     %ANDROID_HOME%\emulator
     ```

4. Save the changes and restart your Command Prompt or system.

---

## **3. Verify ADB Setup**
1. Open Command Prompt (`Win + R`, type `cmd`).
2. Run:
   adb --version
   node --version
   npm --version
3.Connect device remove with your IP:
   adb connect <device_ip>:5555


---

This `README.md` provides a comprehensive guide for setting up the Android environment and using ADB and Node.js. Let me know if you need any further customization or help!
