package com.traxxiontech.savebox.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.traxxiontech.savebox.models.DownloadEntity;

@Database(entities = {DownloadEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    
    private static AppDatabase instance;
    public abstract DownloadDao downloadDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "savebox_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}