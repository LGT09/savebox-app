# Sketchware Pro Project Setup Guide

## 🎯 Installation Instructions

### Step 1: Project Preparation
1. Download all source files from this repository
2. Extract the contents to a working directory
3. Open Sketchware Pro application

### Step 2: Create New Project in Sketchware Pro
```
1. Click "New Project"
2. Project Name: SaveBox
3. Package Name: com.traxxiontech.savebox
4. Target API: 33
5. Min API: 24
```

### Step 3: Import Source Files

#### Java Files
1. Navigate to **Source Code** section
2. Right-click and select **Import Files**
3. Select all `.java` files from:
   ```
   app/src/main/java/com/traxxiontech/savebox/
   ```
4. Folder structure will auto-organize

#### Layout Files
1. Go to **Layouts** section
2. Import all `.xml` layout files from:
   ```
   app/src/main/res/layout/
   ```

#### Resources
1. Go to **Resources** section
2. Import strings, colors, and themes from:
   ```
   app/src/main/res/values/
   ```

### Step 4: Add Dependencies

In Sketchware Pro, go to **Project Settings** → **Dependencies**:

```gradle
// Core
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.recyclerview:recyclerview:1.3.1'
implementation 'androidx.cardview:cardview:1.0.0'

// Material Design
implementation 'com.google.android.material:material:1.9.0'

// Architecture
implementation 'androidx.lifecycle:lifecycle-viewmodel:2.6.1'
implementation 'androidx.lifecycle:lifecycle-livedata:2.6.1'

// Database
implementation 'androidx.room:room-runtime:2.5.2'
annotationProcessor 'androidx.room:room-compiler:2.5.2'

// Networking
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.squareup.okhttp3:okhttp:4.11.0'

// Media
implementation 'androidx.media3:media3-exoplayer:1.1.1'
implementation 'androidx.media3:media3-ui:1.1.1'

// Background Tasks
implementation 'androidx.work:work-runtime:2.8.1'

// Image Loading
implementation 'com.github.bumptech.glide:glide:4.15.1'

// Animations
implementation 'com.airbnb.android:lottie:6.1.0'

// QR Scanner
implementation 'com.journeyapps:zxing-android-embedded:4.3.0'
```

### Step 5: Configure AndroidManifest.xml

In Sketchware Pro:
1. Go to **AndroidManifest.xml**
2. Add required permissions:
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
   <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
   <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
   <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
   ```

3. Add Activities:
   ```xml
   <activity android:name=".activities.SplashActivity"
       android:exported="true">
       <intent-filter>
           <action android:name="android.intent.action.MAIN" />
           <category android:name="android.intent.category.LAUNCHER" />
       </intent-filter>
   </activity>
   
   <activity android:name=".activities.ComplianceActivity" />
   <activity android:name=".activities.MainActivity" />
   <activity android:name=".activities.DownloadActivity" />
   <activity android:name=".activities.SettingsActivity" />
   ```

### Step 6: Connect API Endpoints

1. In each Activity, configure the ViewModel
2. Set API base URLs in `ApiClient.java`:
   ```java
   // OmegaTech
   private static final String OMEGATECH_BASE_URL = "https://omegatech-api.dixonomega.tech/";
   
   // davidcyril
   private static final String DAVIDCYRIL_BASE_URL = "https://apis.davidcyril.name.ng/";
   ```

3. Test API connections:
   ```java
   viewModel.downloadFromUrl("https://www.youtube.com/watch?v=VIDEO_ID");
   ```

### Step 7: Configure Database

1. In `AppDatabase.java`, Room will auto-create tables
2. Initialize database in Application class:
   ```java
   AppDatabase.getInstance(getApplicationContext());
   ```

### Step 8: Build & Test

1. Click **Build** → **Build APK**
2. Wait for compilation to complete
3. Install on device or emulator:
   ```bash
   adb install -r savebox-app-debug.apk
   ```

4. Test each feature:
   - ✅ Splash screen
   - ✅ Compliance screen
   - ✅ URL input
   - ✅ API calls
   - ✅ Downloads
   - ✅ Settings

### Step 9: Project Structure in Sketchware

```
SaveBox (Project)
├── Activities
│   ├── SplashActivity
│   ├── ComplianceActivity
│   ├── MainActivity
│   ├── DownloadActivity
│   └── SettingsActivity
├── Models
│   ├── DownloadEntity
│   └── DownloadResponse
├── ViewModels
│   ├── DownloadViewModel
│   └── HistoryViewModel
├── Repositories
│   └── DownloadRepository
├── Network
│   ├── ApiClient
│   ├── ApiService
│   └── PlatformDetector
├── Database
│   ├── AppDatabase
│   └── DownloadDao
├── Adapters
│   └── DownloadAdapter
├── Utils
│   ├── UrlValidator
│   ├── StorageManager
│   ├── PreferenceManager
│   └── CustomEditText
├── Workers
│   └── DownloadWorker
├── Layouts
│   ├── activity_splash.xml
│   ├── activity_compliance.xml
│   ├── activity_main.xml
│   ├── activity_downloads.xml
│   ├── activity_settings.xml
│   └── item_download.xml
├── Resources
│   ├── strings.xml
│   ├── colors.xml
│   └── themes.xml
└── Manifest
    └── AndroidManifest.xml
```

## 🔧 Troubleshooting

### Import Errors
- Ensure all files are in correct package structure
- Check that dependencies are added correctly
- Verify Java version compatibility (Java 11)

### API Connection Issues
- Test API endpoints with curl first
- Check internet permissions in manifest
- Verify base URLs in ApiClient.java

### Database Errors
- Ensure Room compiler is added
- Check entity annotations
- Verify DAO method signatures

### Build Failures
- Clean project: **Build** → **Clean**
- Rebuild: **Build** → **Rebuild Project**
- Check Android SDK is updated
- Verify target API compatibility

## 📱 Testing on Device

```bash
# Connect device via USB
adb devices

# Install APK
adb install -r app-debug.apk

# View logs
adb logcat

# Uninstall
adb uninstall com.traxxiontech.savebox
```

## 🚀 Release Build

1. Create keystore (if not exists):
   ```bash
   keytool -genkey -alias savebox -keystore savebox.keystore -keyalg RSA -keysize 2048 -validity 365
   ```

2. In Sketchware Pro:
   - Go to **Build** → **Build Signed APK**
   - Select keystore file
   - Enter password
   - Output: `savebox-app-release.apk`

3. Sign APK:
   ```bash
   jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore savebox.keystore savebox-app-release.apk savebox
   ```

## 📝 Notes

- All API keys are public (no authentication required)
- Ensure compliance with platform terms of service
- Test thoroughly before release
- Keep dependencies updated
- Follow Material Design 3 guidelines

## 🆘 Support

For issues:
1. Check Sketchware Pro documentation
2. Review API endpoint documentation
3. Check Android developer guides
4. Review commit history for changes
