package com.traxxiontech.savebox.repositories;

import android.content.Context;
import com.traxxiontech.savebox.database.AppDatabase;
import com.traxxiontech.savebox.database.DownloadDao;
import com.traxxiontech.savebox.models.DownloadEntity;
import com.traxxiontech.savebox.models.DownloadResponse;
import com.traxxiontech.savebox.network.ApiClient;
import com.traxxiontech.savebox.network.ApiService;
import com.traxxiontech.savebox.network.PlatformDetector;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadRepository {
    private DownloadDao downloadDao;
    private ApiService omegaTechService;
    private ApiService davidCyrilService;

    public DownloadRepository(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        downloadDao = database.downloadDao();
        omegaTechService = ApiClient.getOmegaTechService();
        davidCyrilService = ApiClient.getDavidCyrilService();
    }

    // Insert download record
    public void insertDownload(DownloadEntity download) {
        new Thread(() -> downloadDao.insert(download)).start();
    }

    // Get all downloads
    public void getAllDownloads(Callback<List<DownloadEntity>> callback) {
        new Thread(() -> {
            List<DownloadEntity> downloads = downloadDao.getAllDownloads();
            // Note: In real app, use proper callback mechanism
        }).start();
    }

    // Download from URL based on platform
    public Call<DownloadResponse> downloadFromUrl(String url) {
        PlatformDetector.Platform platform = PlatformDetector.detectPlatform(url);

        switch (platform) {
            case YOUTUBE:
                return omegaTechService.downloadYtDl(url);
            case TIKTOK:
                return davidCyrilService.downloadTikTok(url);
            case INSTAGRAM:
                return davidCyrilService.downloadInstagram(url);
            case TWITTER:
                return davidCyrilService.downloadTwitter(url);
            case FACEBOOK:
                return davidCyrilService.downloadFacebook(url);
            case SPOTIFY:
                return davidCyrilService.downloadSpotify(url);
            default:
                return omegaTechService.downloadAll(url);
        }
    }

    // Search YouTube MP3
    public Call<DownloadResponse> searchYoutubeMp3(String query) {
        return omegaTechService.searchYtMp3(query);
    }

    // Search Spotify
    public Call<DownloadResponse> searchSpotify(String query) {
        return omegaTechService.searchSpotify(query);
    }

    // Search Song
    public Call<DownloadResponse> searchSong(String query) {
        return davidCyrilService.searchSong(query);
    }
}