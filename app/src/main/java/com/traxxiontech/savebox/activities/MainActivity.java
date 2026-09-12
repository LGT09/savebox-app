package com.traxxiontech.savebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.traxxiontech.savebox.R;
import com.traxxiontech.savebox.models.DownloadEntity;
import com.traxxiontech.savebox.utils.UrlValidator;
import com.traxxiontech.savebox.viewmodels.DownloadViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText urlInput;
    private Button downloadButton;
    private Button scanQrButton;
    private Button navDownloads;
    private Button navFavorites;
    private ProgressBar progressBar;
    private DownloadViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupViewModel();
        setupListeners();
    }

    private void initViews() {
        urlInput = findViewById(R.id.et_url_input);
        downloadButton = findViewById(R.id.btn_download);
        scanQrButton = findViewById(R.id.btn_scan_qr);
        navDownloads = findViewById(R.id.btn_nav_downloads);
        navFavorites = findViewById(R.id.btn_nav_favorites);
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @Override
            public <T extends androidx.lifecycle.ViewModel> T create(Class<T> modelClass) {
                if (modelClass.isAssignableFrom(DownloadViewModel.class)) {
                    return (T) new DownloadViewModel(MainActivity.this);
                }
                throw new IllegalArgumentException("Unknown ViewModel");
            }
        }).get(DownloadViewModel.class);

        viewModel.getDownloadData().observe(this, response -> {
            if (response != null) {
                // Navigate to download activity with response
                Intent intent = new Intent(MainActivity.this, DownloadActivity.class);
                intent.putExtra("title", response.getTitle());
                intent.putExtra("thumbnail", response.getThumbnail());
                intent.putExtra("url", response.getUrl());
                intent.putExtra("quality", response.getQuality());
                startActivity(intent);
            }
        });

        viewModel.getErrorMessage().observe(this, error -> {
            if (error != null) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupListeners() {
        downloadButton.setOnClickListener(v -> handleDownloadClick());
        scanQrButton.setOnClickListener(v -> handleScanQr());
        navDownloads.setOnClickListener(v -> navigateToDownloads());
        navFavorites.setOnClickListener(v -> navigateToFavorites());
    }

    private void handleDownloadClick() {
        String url = urlInput.getText().toString().trim();
        
        if (url.isEmpty()) {
            Toast.makeText(this, "Please enter a URL", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!UrlValidator.isValidUrl(url)) {
            Toast.makeText(this, "Invalid URL format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!UrlValidator.isSupportedPlatform(url)) {
            Toast.makeText(this, "Platform not supported", Toast.LENGTH_SHORT).show();
            return;
        }

        viewModel.downloadFromUrl(url);
    }

    private void handleScanQr() {
        Toast.makeText(this, "QR Scanner coming soon", Toast.LENGTH_SHORT).show();
    }

    private void navigateToDownloads() {
        startActivity(new Intent(MainActivity.this, DownloadActivity.class));
    }

    private void navigateToFavorites() {
        Toast.makeText(this, "Favorites feature coming soon", Toast.LENGTH_SHORT).show();
    }
}