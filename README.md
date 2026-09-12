# SaveBox - Media Download Assistant

A legal media management and download assistant for Android built with Sketchware. Download and manage media from YouTube, Spotify, TikTok, Instagram, Twitter, and Facebook responsibly.

## 🎯 Features

- **Multi-Platform Support**: YouTube, Spotify, TikTok, Instagram, Twitter, Facebook
- **Legal Compliance**: Rights safeguards and platform terms compliance
- **User Privacy**: Local data processing, encrypted history
- **Beautiful UI**: Material Design 3 with dark/light themes
- **Offline Access**: Download management and media playback
- **Smart API Integration**: Multiple API endpoints for reliability

## 🔗 Integrated APIs

### OmegaTech API (https://omegatech-api.dixonomega.tech)
- `/api/download/play` - Universal downloader
- `/api/download/yt-dl` - YouTube download
- `/api/download/Yt-mate` - YouTube alternative
- `/api/download/All-downloader-v2` - Multi-platform v2
- `/api/download/all` - All platforms
- `/api/Search/yt-mp3` - YouTube MP3 search
- `/api/Search/Spotify` - Spotify search

### davidcyril API (https://apis.davidcyril.name.ng)
- `/download/ytmp444` - YouTube MP4
- `/download/ytmp3` - YouTube MP3
- `/twitterV2` - Twitter videos
- `/download/tiktokv4` - TikTok videos
- `/spotifydl2` - Spotify downloader
- `/song` - Music search
- `/instagram` - Instagram content
- `/endpoints/download/#facebook-video-v3` - Facebook videos
- `/download/aiov3` - AIO downloader

## 📋 Compliance & Privacy

✅ User rights protection  
✅ Platform terms compliance  
✅ Local data processing  
✅ Encrypted history database  
✅ No unauthorized scraping  
✅ Copyright information preservation  

## 🏗️ Architecture

- **Platform**: Android (Sketchware)
- **Language**: Java
- **Architecture**: MVVM
- **UI Framework**: Material Design 3 with XML Layouts
- **Database**: Room
- **Networking**: Retrofit + OkHttp
- **Media Playback**: ExoPlayer
- **Background Tasks**: WorkManager

## 📦 Project Structure

```
com.traxxiontech.savebox
├── activities
├── fragments
├── adapters
├── models
├── viewmodels
├── repositories
├── network
│   ├── ApiClient
│   └── ApiService
├── database
├── workers
├── services
├── utils
└── player
```

## 🚀 Development Phases

**Phase 1**: UI Foundation & Compliance  
**Phase 2**: API Integration & URL Detection  
**Phase 3**: Download Manager & Database  
**Phase 4**: Media Player & Favorites  
**Phase 5**: Optimization & Release  

## 📄 License

Apache License 2.0

## 👨‍💻 Created by

Vincent Ganiza (Traxxion Tech)  
Proudly Made in Zimbabwe 🇿🇼  
© 2026
