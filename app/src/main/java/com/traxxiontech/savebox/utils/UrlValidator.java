package com.traxxiontech.savebox.utils;

import android.util.Patterns;
import com.traxxiontech.savebox.network.PlatformDetector;

public class UrlValidator {
    
    public static boolean isValidUrl(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }
        return Patterns.WEB_URL.matcher(url).matches();
    }

    public static boolean isSupportedPlatform(String url) {
        return PlatformDetector.isSupportedPlatform(url);
    }

    public static boolean canDownload(String url) {
        return isValidUrl(url) && isSupportedPlatform(url);
    }

    public static String getPlatformName(String url) {
        PlatformDetector.Platform platform = PlatformDetector.detectPlatform(url);
        switch (platform) {
            case YOUTUBE:
                return "YouTube";
            case TIKTOK:
                return "TikTok";
            case INSTAGRAM:
                return "Instagram";
            case TWITTER:
                return "Twitter";
            case FACEBOOK:
                return "Facebook";
            case SPOTIFY:
                return "Spotify";
            default:
                return "Unknown";
        }
    }

    public static int getPlatformIcon(String url) {
        PlatformDetector.Platform platform = PlatformDetector.detectPlatform(url);
        switch (platform) {
            case YOUTUBE:
                return android.R.drawable.ic_media_play;
            case TIKTOK:
                return android.R.drawable.ic_media_play;
            case INSTAGRAM:
                return android.R.drawable.ic_dialog_info;
            case TWITTER:
                return android.R.drawable.ic_dialog_info;
            case FACEBOOK:
                return android.R.drawable.ic_dialog_info;
            case SPOTIFY:
                return android.R.drawable.ic_media_play;
            default:
                return android.R.drawable.ic_dialog_info;
        }
    }
}