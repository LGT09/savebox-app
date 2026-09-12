package com.traxxiontech.savebox.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "downloads")
public class DownloadEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    
    private String title;
    private String url;
    private String filePath;
    private String thumbnail;
    private String platform;
    private String fileSize;
    private long timestamp;
    private int status; // 0: pending, 1: downloading, 2: completed, 3: failed

    public DownloadEntity() {
    }

    public DownloadEntity(String title, String url, String platform) {
        this.title = title;
        this.url = url;
        this.platform = platform;
        this.timestamp = System.currentTimeMillis();
        this.status = 0;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
