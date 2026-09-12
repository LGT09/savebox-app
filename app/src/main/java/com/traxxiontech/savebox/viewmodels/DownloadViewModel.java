package com.traxxiontech.savebox.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.content.Context;
import com.traxxiontech.savebox.models.DownloadEntity;
import com.traxxiontech.savebox.models.DownloadResponse;
import com.traxxiontech.savebox.repositories.DownloadRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DownloadViewModel extends ViewModel {
    private DownloadRepository repository;
    private MutableLiveData<DownloadResponse> downloadData = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public DownloadViewModel(Context context) {
        repository = new DownloadRepository(context);
    }

    public LiveData<DownloadResponse> getDownloadData() {
        return downloadData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMessage;
    }

    public LiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void downloadFromUrl(String url) {
        isLoading.setValue(true);
        Call<DownloadResponse> call = repository.downloadFromUrl(url);
        call.enqueue(new Callback<DownloadResponse>() {
            @Override
            public void onResponse(Call<DownloadResponse> call, Response<DownloadResponse> response) {
                isLoading.setValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    downloadData.setValue(response.body());
                } else {
                    errorMessage.setValue("Failed to fetch download info");
                }
            }

            @Override
            public void onFailure(Call<DownloadResponse> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue("Error: " + t.getMessage());
            }
        });
    }

    public void searchYoutubeMp3(String query) {
        isLoading.setValue(true);
        Call<DownloadResponse> call = repository.searchYoutubeMp3(query);
        call.enqueue(new Callback<DownloadResponse>() {
            @Override
            public void onResponse(Call<DownloadResponse> call, Response<DownloadResponse> response) {
                isLoading.setValue(false);
                if (response.isSuccessful() && response.body() != null) {
                    downloadData.setValue(response.body());
                } else {
                    errorMessage.setValue("Search failed");
                }
            }

            @Override
            public void onFailure(Call<DownloadResponse> call, Throwable t) {
                isLoading.setValue(false);
                errorMessage.setValue("Error: " + t.getMessage());
            }
        });
    }

    public void saveDownloadRecord(DownloadEntity entity) {
        repository.insertDownload(entity);
    }
}