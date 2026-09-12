package com.traxxiontech.savebox.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class StorageManager {
    
    private static final String SAVEBOX_DIR = "SaveBox";
    private static final String DOWNLOADS_DIR = "Downloads";
    private static final String VIDEOS_DIR = "Videos";
    private static final String MUSIC_DIR = "Music";
    private static final String IMAGES_DIR = "Images";

    public static File getSaveBoxDirectory(Context context) {
        File file = new File(context.getExternalFilesDir(null), SAVEBOX_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getDownloadsDirectory(Context context) {
        File file = new File(getSaveBoxDirectory(context), DOWNLOADS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getVideosDirectory(Context context) {
        File file = new File(getSaveBoxDirectory(context), VIDEOS_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getMusicDirectory(Context context) {
        File file = new File(getSaveBoxDirectory(context), MUSIC_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getImagesDirectory(Context context) {
        File file = new File(getSaveBoxDirectory(context), IMAGES_DIR);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static long getAvailableStorage() {
        return Environment.getExternalStorageDirectory().getFreeSpace();
    }

    public static boolean hasEnoughSpace(long requiredSize) {
        return getAvailableStorage() > requiredSize;
    }
}