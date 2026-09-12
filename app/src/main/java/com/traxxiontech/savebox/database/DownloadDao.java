package com.traxxiontech.savebox.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.traxxiontech.savebox.models.DownloadEntity;
import java.util.List;

@Dao
public interface DownloadDao {
    
    @Insert
    long insert(DownloadEntity download);

    @Update
    void update(DownloadEntity download);

    @Delete
    void delete(DownloadEntity download);

    @Query("SELECT * FROM downloads ORDER BY timestamp DESC")
    List<DownloadEntity> getAllDownloads();

    @Query("SELECT * FROM downloads WHERE id = :id")
    DownloadEntity getDownloadById(int id);

    @Query("SELECT * FROM downloads WHERE platform = :platform ORDER BY timestamp DESC")
    List<DownloadEntity> getDownloadsByPlatform(String platform);

    @Query("SELECT * FROM downloads WHERE status = :status ORDER BY timestamp DESC")
    List<DownloadEntity> getDownloadsByStatus(int status);

    @Query("DELETE FROM downloads WHERE id = :id")
    void deleteById(int id);

    @Query("SELECT COUNT(*) FROM downloads")
    int getTotalDownloads();

    @Query("SELECT * FROM downloads WHERE timestamp > :timestamp ORDER BY timestamp DESC")
    List<DownloadEntity> getRecentDownloads(long timestamp);
}