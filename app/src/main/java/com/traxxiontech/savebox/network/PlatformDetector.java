package com.traxxiontech.savebox.network;

public class PlatformDetector {
    
    public enum Platform {
        YOUTUBE,
        TIKTOK,
        INSTAGRAM,
        TWITTER,
        FACEBOOK,
        SPOTIFY,
        UNKNOWN
    }

    public static Platform detectPlatform(String url) {
        if (url == null || url.isEmpty()) {
            return Platform.UNKNOWN;
        }

        url = url.toLowerCase();

        if (url.contains("youtube.com") || url.contains("youtu.be")) {
            return Platform.YOUTUBE;
        } else if (url.contains("tiktok.com")) {
            return Platform.TIKTOK;
        } else if (url.contains("instagram.com")) {
            return Platform.INSTAGRAM;
        } else if (url.contains("twitter.com") || url.contains("x.com")) {
            return Platform.TWITTER;
        } else if (url.contains("facebook.com") || url.contains("fb.com")) {
            return Platform.FACEBOOK;
        } else if (url.contains("spotify.com")) {
            return Platform.SPOTIFY;
        }

        return Platform.UNKNOWN;
    }

    public static boolean isValidUrl(String url) {
        return url != null && (url.startsWith("http://") || url.startsWith("https://"));
    }

    public static boolean isSupportedPlatform(String url) {
        return detectPlatform(url) != Platform.UNKNOWN;
    }
}