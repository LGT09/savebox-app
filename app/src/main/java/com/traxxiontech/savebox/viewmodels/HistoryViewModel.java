package com.traxxiontech.savebox.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.traxxiontech.savebox.models.DownloadEntity;
import java.util.List;

public class HistoryViewModel extends ViewModel {
    private MutableLiveData<List<DownloadEntity>> downloadHistory = new MutableLiveData<>();
    private MutableLiveData<List<String>> recentSearches = new MutableLiveData<>();

    public LiveData<List<DownloadEntity>> getDownloadHistory() {
        return downloadHistory;
    }

    public LiveData<List<String>> getRecentSearches() {
        return recentSearches;
    }

    public void loadHistory() {
        // Load from database
    }

    public void addRecentSearch(String query) {
        // Add to recent searches
    }

    public void clearHistory() {
        // Clear history from database
    }
}