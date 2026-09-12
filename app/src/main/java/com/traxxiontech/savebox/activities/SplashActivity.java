package com.traxxiontech.savebox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import com.traxxiontech.savebox.R;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Check if user has accepted compliance
            boolean complianceAccepted = getSharedPreferences("SaveBox", MODE_PRIVATE)
                    .getBoolean("compliance_accepted", false);

            if (complianceAccepted) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            } else {
                startActivity(new Intent(SplashActivity.this, ComplianceActivity.class));
            }
            finish();
        }, SPLASH_DURATION);
    }
}