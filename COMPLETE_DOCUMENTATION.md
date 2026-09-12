# SaveBox - Media Download Assistant

## Complete Setup & Documentation

**Version:** 1.0.0  
**Created:** September 2026  
**Author:** Vincent Ganiza (Traxxion Tech)  
**License:** Apache 2.0  

---

## 📋 Project Overview

SaveBox is a legal, compliance-first media download assistant for Android. It enables users to download and manage content from multiple platforms while respecting copyright laws and platform terms of service.

### Key Features
- ✅ Multi-platform support (YouTube, Spotify, TikTok, Instagram, Twitter, Facebook)
- ✅ Legal compliance framework
- ✅ User privacy protection
- ✅ Beautiful Material Design 3 UI
- ✅ Offline media playback
- ✅ Background download management

---

## 🏗️ Architecture

### MVVM Pattern Implementation
```
┌─────────────────────────────────────┐
│      UI Layer (Activities)          │
├─────────────────────────────────────┤
│   ViewModel (Business Logic)        │
├─────────────────────────────────────┤
│   Repository (Data Access)          │
├─────────────────────────────────────┤
│  Data Layer (API/Database/Storage)  │
└─────────────────────────────────────┘
```

### Directory Structure
```
com.traxxiontech.savebox/
├── activities/           # UI Components
├── fragments/           # Fragment UIs
├── adapters/            # RecyclerView Adapters
├── models/              # Data Models
├── viewmodels/          # ViewModel Logic
├── repositories/        # Data Repository
├── network/             # API Integration
├── database/            # Room Database
├── workers/             # Background Tasks
├── services/            # Services
├── utils/               # Utilities
└── player/              # Media Playback
```

---

## 🔗 API Integration

### Supported Endpoints

#### OmegaTech API (https://omegatech-api.dixonomega.tech/)
| Endpoint | Purpose |
|----------|----------|
| `/api/download/play` | Universal downloader |
| `/api/download/yt-dl` | YouTube downloader |
| `/api/download/Yt-mate` | YouTube alternative |
| `/api/download/All-downloader-v2` | Multi-platform v2 |
| `/api/download/all` | All platforms |
| `/api/Search/yt-mp3` | YouTube MP3 search |
| `/api/Search/Spotify` | Spotify search |

#### davidcyril API (https://apis.davidcyril.name.ng/)
| Endpoint | Purpose |
|----------|----------|
| `/download/ytmp444` | YouTube MP4 |
| `/download/ytmp3` | YouTube MP3 |
| `/twitterV2` | Twitter/X videos |
| `/download/tiktokv4` | TikTok videos |
| `/spotifydl2` | Spotify music |
| `/song` | Music search |
| `/instagram` | Instagram content |
| `/endpoints/download/#facebook-video-v3` | Facebook videos |
| `/download/aiov3` | AIO downloader |

---

## 📦 Dependencies

### Core AndroidX
- `androidx.appcompat:appcompat:1.6.1`
- `androidx.constraintlayout:constraintlayout:2.1.4`
- `androidx.recyclerview:recyclerview:1.3.1`
- `androidx.cardview:cardview:1.0.0`

### Material & UI
- `com.google.android.material:material:1.9.0`
- `com.airbnb.android:lottie:6.1.0`

### Architecture Components
- `androidx.lifecycle:lifecycle-viewmodel:2.6.1`
- `androidx.lifecycle:lifecycle-livedata:2.6.1`
- `androidx.room:room-runtime:2.5.2`

### Networking
- `com.squareup.retrofit2:retrofit:2.9.0`
- `com.squareup.retrofit2:converter-gson:2.9.0`
- `com.squareup.okhttp3:okhttp:4.11.0`
- `com.google.code.gson:gson:2.10.1`

### Media & Files
- `androidx.media3:media3-exoplayer:1.1.1`
- `androidx.media3:media3-ui:1.1.1`
- `com.github.bumptech.glide:glide:4.15.1`

### Background Tasks
- `androidx.work:work-runtime:2.8.1`

### Scanning
- `com.journeyapps:zxing-android-embedded:4.3.0`

---

## 🚀 Getting Started

### For Sketchware Pro Users
See [SKETCHWARE_SETUP_GUIDE.md](SKETCHWARE_SETUP_GUIDE.md) for complete instructions.

### For Android Studio Users
```bash
# Clone repository
git clone https://github.com/LGT09/savebox-app.git
cd savebox-app

# Build project
./gradlew build

# Run on device
./gradlew installDebug

# Create signed APK
./gradlew assembleRelease
```

---

## 🔒 Security & Compliance

### User Privacy
- ✅ Local data processing
- ✅ No remote data upload
- ✅ Encrypted database storage
- ✅ Minimal permissions requested

### Platform Compliance
- ✅ URL validation (whitelist)
- ✅ Platform detection
- ✅ Terms acceptance flow
- ✅ Copyright metadata preservation

### Permissions Policy

**Required:**
- `INTERNET` - API requests
- `READ_EXTERNAL_STORAGE` - Access media
- `WRITE_EXTERNAL_STORAGE` - Save downloads
- `POST_NOTIFICATIONS` - Download alerts

**Optional:**
- `RECORD_AUDIO` - Voice search
- `CAMERA` - QR scanning

**Never Requested:**
- `READ_CONTACTS`
- `SEND_SMS`
- `READ_CALL_LOG`
- `ACCESS_FINE_LOCATION`

---

## 📲 User Flow

### First Launch
```
Splash → Compliance Check → Theme Selection → Home
```

### Download Flow
```
Home → Paste URL → Platform Detection → Preview → Download → Manager → Completed
```

### Navigation
```
Bottom Navigation:
🏠 Home      ⬇ Downloads      ⭐ Favorites      ⚙ Settings
```

---

## 🛠️ Development Roadmap

### Phase 1: Foundation ✅
- [x] Splash screen
- [x] Compliance UI
- [x] Home screen
- [x] Material Design setup

### Phase 2: API Integration ✅
- [x] Network layer (Retrofit)
- [x] Platform detector
- [x] API endpoints
- [x] ViewModel setup

### Phase 3: Downloads (In Progress)
- [ ] Download manager
- [ ] Progress tracking
- [ ] File storage
- [ ] History database

### Phase 4: Playback
- [ ] Media player
- [ ] Video playback
- [ ] Audio playback
- [ ] Favorites system

### Phase 5: Polish
- [ ] Animations
- [ ] Performance optimization
- [ ] Testing
- [ ] Release build

---

## 🧪 Testing

### Unit Tests
```bash
./gradlew test
```

### Instrumented Tests
```bash
./gradlew connectedAndroidTest
```

### Manual Testing Checklist
- [ ] Splash screen animation
- [ ] Compliance acceptance
- [ ] URL input validation
- [ ] Platform detection
- [ ] API response handling
- [ ] Download progress
- [ ] File saving
- [ ] Database queries
- [ ] Theme switching
- [ ] Permission requests

---

## 📚 API Documentation

Detailed API documentation available in [API_DOCUMENTATION.md](API_DOCUMENTATION.md)

### Quick Test
```bash
# Test YouTube download
curl "https://omegatech-api.dixonomega.tech/api/download/yt-dl?url=https://www.youtube.com/watch?v=VIDEO_ID"

# Test Spotify search
curl "https://apis.davidcyril.name.ng/song?query=artist%20name"
```

---

## 🐛 Troubleshooting

### Common Issues

**Build Fails**
- Clear build cache: `./gradlew clean`
- Update dependencies: `./gradlew dependencies`
- Check Java version: `java -version` (requires 11+)

**API Errors**
- Verify internet connectivity
- Check URL format
- Test with curl first
- Review API response format

**Database Issues**
- Clear app data: `adb shell pm clear com.traxxiontech.savebox`
- Rebuild database: Delete and reinstall
- Check Room migrations

---

## 📄 License

Apache License 2.0 - See LICENSE file for details

---

## 👨‍💻 Author

**Vincent Ganiza**  
Traxxion Tech  
Proudly Made in Zimbabwe 🇿🇼  
© 2026

---

## 🤝 Contributing

1. Fork the repository
2. Create feature branch: `git checkout -b feature/amazing-feature`
3. Commit changes: `git commit -m 'Add amazing feature'`
4. Push branch: `git push origin feature/amazing-feature`
5. Open Pull Request

---

## 📞 Support

For issues and questions:
1. Check existing GitHub Issues
2. Review documentation
3. Create new Issue with details
4. Contact: [your contact]

---

## 🙏 Acknowledgments

- OmegaTech API team
- davidcyril API maintainers
- Sketchware Pro community
- Material Design team

---

**Last Updated:** September 12, 2026
