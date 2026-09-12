package com.traxxiontech.savebox.network;

import com.traxxiontech.savebox.models.DownloadResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // OmegaTech API Endpoints
    @GET("api/download/play")
    Call<DownloadResponse> downloadPlay(@Query("url") String url);

    @GET("api/download/yt-dl")
    Call<DownloadResponse> downloadYtDl(@Query("url") String url);

    @GET("api/download/Yt-mate")
    Call<DownloadResponse> downloadYtMate(@Query("url") String url);

    @GET("api/download/All-downloader-v2")
    Call<DownloadResponse> downloadAllV2(@Query("url") String url);

    @GET("api/download/all")
    Call<DownloadResponse> downloadAll(@Query("url") String url);

    @GET("api/Search/yt-mp3")
    Call<DownloadResponse> searchYtMp3(@Query("query") String query);

    @GET("api/Search/Spotify")
    Call<DownloadResponse> searchSpotify(@Query("query") String query);

    // davidcyril API Endpoints
    @GET("download/ytmp444")
    Call<DownloadResponse> downloadYtMp4(@Query("url") String url);

    @GET("download/ytmp3")
    Call<DownloadResponse> downloadYtMp3(@Query("url") String url);

    @GET("twitterV2")
    Call<DownloadResponse> downloadTwitter(@Query("url") String url);

    @GET("download/tiktokv4")
    Call<DownloadResponse> downloadTikTok(@Query("url") String url);

    @GET("spotifydl2")
    Call<DownloadResponse> downloadSpotify(@Query("url") String url);

    @GET("song")
    Call<DownloadResponse> searchSong(@Query("query") String query);

    @GET("instagram")
    Call<DownloadResponse> downloadInstagram(@Query("url") String url);

    @GET("endpoints/download/#facebook-video-v3")
    Call<DownloadResponse> downloadFacebook(@Query("url") String url);

    @GET("download/aiov3")
    Call<DownloadResponse> downloadAio(@Query("url") String url);
}