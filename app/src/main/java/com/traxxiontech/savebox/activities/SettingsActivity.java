package com.traxxiontech.savebox.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.traxxiontech.savebox.R;
import com.traxxiontech.savebox.utils.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {

    private PreferenceManager prefManager;
    private Spinner themeSpinner;
    private CheckBox notificationsCheckbox;
    private Button clearCacheButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        prefManager = new PreferenceManager(this);
        initViews();
        loadSettings();
        setupListeners();
    }

    private void initViews() {
        themeSpinner = findViewById(R.id.spinner_theme);
        notificationsCheckbox = findViewById(R.id.cb_notifications);
        clearCacheButton = findViewById(R.id.btn_clear_cache);
    }

    private void loadSettings() {
        notificationsCheckbox.setChecked(prefManager.isNotificationsEnabled());
    }

    private void setupListeners() {
        notificationsCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            prefManager.setNotificationsEnabled(isChecked);
            Toast.makeText(this, "Notifications " + (isChecked ? "enabled" : "disabled"), Toast.LENGTH_SHORT).show();
        });

        clearCacheButton.setOnClickListener(v -> {
            clearCache();
            Toast.makeText(this, "Cache cleared", Toast.LENGTH_SHORT).show();
        });
    }

    private void clearCache() {
        // Clear app cache
        try {
            java.io.File dir = getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean deleteDir(java.io.File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                boolean success = deleteDir(new java.io.File(dir, child));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}